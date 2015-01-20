package com.akshay.hackerrank.algorithms;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TwoArrayProblem {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] arr = line.split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		int[] x = new int[N];
		int[] y = new int[N];
		fillArray(scanner.nextLine(),x);
		fillArray(scanner.nextLine(),y);
		while (M-- > 0) {
			performOperations(scanner.nextLine(),x,y);
		}
		
	}

	private static void performOperations(String line, int[] x, int[] y) {
		String[] tokens = line.split(" ");
		if (tokens.length == 4) {
			reverseSubArray(tokens,x,y);
		}
		else if (tokens.length == 6) {
			swapFragments(tokens,x,y);
		}
		else if (tokens.length == 3 && Integer.parseInt(tokens[0]) == 3) {
			swapPiece(tokens,x,y);
		}
		else {
			findMinimalRadius(tokens,x,y);
		}
	}

	private static void findMinimalRadius(String[] tokens, int[] x, int[] y) {
		int left = Integer.parseInt(tokens[1]) - 1;
		int right = Integer.parseInt(tokens[2]) - 1;
		List<Point> listOfPoints = new ArrayList<Point>();
		for (int i = left; i <= right; i++) {
			listOfPoints.add(new Point(x[i], y[i]));
		}
		System.out.println(String.valueOf(SmallestEnclosingCircle.makeCircle(listOfPoints).r).substring(0, 4));
	}

	private static void swapPiece(String[] tokens, int[] x, int[] y) {
		int left = Integer.parseInt(tokens[1]) - 1;
		int right = Integer.parseInt(tokens[2]) - 1;
		for (int i = left; i <= right; i++) {
			swapElements(x, i-1, y, i-1);
		}
	}

	private static void swapFragments(String[] tokens, int[] x, int[] y) {
		int left1 = Integer.parseInt(tokens[2]) - 1;
		int right1 = Integer.parseInt(tokens[3]) - 1;
		int left2 = Integer.parseInt(tokens[4]) - 1;
		int right2 = Integer.parseInt(tokens[5]) - 1;
		if (Integer.parseInt(tokens[1]) == 0) {
			while (left1 <= right1 && left2 <= right2) {
				swapElements(x, left1, x, left2);
				left1++;
				left2++;
			}
		}
		else {
			while (left1 <= right1 && left2 <= right2) {
				swapElements(y, left1, y, left2);
				left1++;
				left2++;
			}
		}
			
	}

	private static void reverseSubArray(String[] tokens, int[] x, int[] y) {
		if (Integer.parseInt(tokens[1]) == 0)
			reverseArray(x,Integer.parseInt(tokens[2]) - 1,Integer.parseInt(tokens[3]) - 1);
		else
			reverseArray(y,Integer.parseInt(tokens[2]) - 1,Integer.parseInt(tokens[3]) - 1);
	}

	private static void reverseArray(int[] arr, int left, int right) {
		while (left <= right) {
			swapElements(arr,left,arr,right);
			left++;
			right--;
		}
	}

	private static void swapElements(int[] arr, int left, int[] arr2, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	private static void fillArray(String line, int[] arr) {
		String[] tokens = line.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			arr[i] = Integer.parseInt(tokens[i]);
		}
	}
	
	public static class SmallestEnclosingCircle {
		
		/* 
		 * Returns the smallest circle that encloses all the given points. Runs in expected O(n) time, randomized.
		 * Note: If 0 points are given, null is returned. If 1 point is given, a circle of radius 0 is returned.
		 */
		// Initially: No boundary points known
		public static Circle makeCircle(List<Point> points) {
			// Clone list to preserve the caller's data, randomize order
			List<Point> shuffled = new ArrayList<Point>(points);
			Collections.shuffle(shuffled, new Random());
			
			// Progressively add points to circle or recompute circle
			Circle c = null;
			for (int i = 0; i < shuffled.size(); i++) {
				Point p = shuffled.get(i);
				if (c == null || !c.contains(p))
					c = makeCircleOnePoint(shuffled.subList(0, i + 1), p);
			}
			return c;
		}
		
		
		// One boundary point known
		private static Circle makeCircleOnePoint(List<Point> points, Point p) {
			Circle c = new Circle(p, 0);
			for (int i = 0; i < points.size(); i++) {
				Point q = points.get(i);
				if (!c.contains(q)) {
					if (c.r == 0)
						c = makeDiameter(p, q);
					else
						c = makeCircleTwoPoints(points.subList(0, i + 1), p, q);
				}
			}
			return c;
		}
		
		
		// Two boundary points known
		private static Circle makeCircleTwoPoints(List<Point> points, Point p, Point q) {
			Circle temp = makeDiameter(p, q);
			if (temp.contains(points))
				return temp;
			
			Circle left = null;
			Circle right = null;
			for (Point r : points) {  // Form a circumcircle with each point
				Point pq = q.subtract(p);
				double cross = pq.cross(r.subtract(p));
				Circle c = makeCircumcircle(p, q, r);
				if (c == null)
					continue;
				else if (cross > 0 && (left == null || pq.cross(c.c.subtract(p)) > pq.cross(left.c.subtract(p))))
					left = c;
				else if (cross < 0 && (right == null || pq.cross(c.c.subtract(p)) < pq.cross(right.c.subtract(p))))
					right = c;
			}
			return right == null || left != null && left.r <= right.r ? left : right;
		}
		
		
		static Circle makeDiameter(Point a, Point b) {
			return new Circle(new Point((a.x + b.x)/ 2, (a.y + b.y) / 2), a.distance(b) / 2);
		}
		
		
		static Circle makeCircumcircle(Point a, Point b, Point c) {
			// Mathematical algorithm from Wikipedia: Circumscribed circle
			double d = (a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) * 2;
			if (d == 0)
				return null;
			double x = (a.norm() * (b.y - c.y) + b.norm() * (c.y - a.y) + c.norm() * (a.y - b.y)) / d;
			double y = (a.norm() * (c.x - b.x) + b.norm() * (a.x - c.x) + c.norm() * (b.x - a.x)) / d;
			Point p = new Point(x, y);
			return new Circle(p, p.distance(a));
		}
		
	}



	static class Circle {
		
		private static double EPSILON = 1e-12;
		
		
		public final Point c;   // Center
		public final double r;  // Radius
		
		
		public Circle(Point c, double r) {
			this.c = c;
			this.r = r;
		}
		
		
		public boolean contains(Point p) {
			return c.distance(p) <= r + EPSILON;
		}
		
		
		public boolean contains(Collection<Point> ps) {
			for (Point p : ps) {
				if (!contains(p))
					return false;
			}
			return true;
		}
		
		
		public String toString() {
			return String.format("Circle(x=%g, y=%g, r=%g)", c.x, c.y, r);
		}
		
	}



	static class Point {
		
		public final double x;
		public final double y;
		
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		
		public Point subtract(Point p) {
			return new Point(x - p.x, y - p.y);
		}
		
		
		public double distance(Point p) {
			return Math.hypot(x - p.x, y - p.y);
		}
		
		
		// Signed area / determinant thing
		public double cross(Point p) {
			return x * p.y - y * p.x;
		}
		
		
		// Magnitude squared
		public double norm() {
			return x * x + y * y;
		}
		
		
		public String toString() {
			return String.format("Point(%g, %g)", x, y);
		}
		
	}
}


