package org.sparta.hellgorithm.week01.lesson;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyExamSearch {
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER =
                new HeightOrderComparator();
        
        public static final Comparator<PhyscData> VISION_ORDER =
        		new VisionOrderComparator();
        

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.height > o2.height) ? 1:
                        (o1.height < o2.height) ? -1 : 0;
            }
        }
        
        private static class VisionOrderComparator implements Comparator<PhyscData> {
        	@Override
        	public int compare(PhyscData o1, PhyscData o2) {
        		return (o1.vision < o2.vision) ? 1:
        			(o1.vision > o2.vision) ? -1 : 0;
        	}
        }
        // o2-o1 일때 내림차순 양수 / 오름차순 음수
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        //키의 오름차순으로 정렬이 되어있다.
        PhyscData[] x = {
                new PhyscData("이나령", 162, 1.4),
                new PhyscData("유지훈", 168, 1.3),
                new PhyscData("이수민", 169, 1.2),
                new PhyscData("김한결", 171, 1.1),
                new PhyscData("홍준기", 173, 0.7),
                new PhyscData("전서현", 174, 0.4),
                new PhyscData("이호연", 175, 0.3),
        };
        
        Comparator<PhyscData> abc=  PhyscData.VISION_ORDER;
        System.out.println(x.toString());
        
        System.out.println("시력이 몇 인 사람을 찾고 있나요?");
        Double vision = stdIn.nextDouble();// 시력 인자값 받기
        int idx = Arrays.binarySearch(
                x,
                new PhyscData("", 0, vision),
                PhyscData.VISION_ORDER
        );
        

        if ( idx < 0 ) {
            System.out.println("요소가 없습니다." + idx);
        }
        else {
            System.out.println("x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }
}
