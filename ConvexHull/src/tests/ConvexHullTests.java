package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import algorithms.JarvisWrap;
import algorithms.LocalRepair;
import algorithms.Point2D;

class ConvexHullTests {
	
	@Test
	void simplelocalrepair() {
		HashSet<Point2D> points = new HashSet<Point2D>();
		points.add(new Point2D(0,0));
		points.add(new Point2D(2,4));
		points.add(new Point2D(6,2));
		ArrayList<Point2D> exphull = new ArrayList<Point2D>();
		exphull.add(new Point2D(0,0));
		exphull.add(new Point2D(6,2));
		exphull.add(new Point2D(2,4));
		assertEquals(exphull,LocalRepair.getConvexHull(points));
	}
	
	@Test
	void simplelocalrepair2() {
		HashSet<Point2D> points = new HashSet<Point2D>();
		points.add(new Point2D(0,0));
		points.add(new Point2D(1,7));
		points.add(new Point2D(2,5));
		points.add(new Point2D(4,2));
		points.add(new Point2D(7,9));
		points.add(new Point2D(9,1));
		points.add(new Point2D(12,2));
		points.add(new Point2D(15,5));
		points.add(new Point2D(18,7));
		points.add(new Point2D(20,5));
		ArrayList<Point2D> exphull = new ArrayList<Point2D>();
		exphull.add(new Point2D(0,0));
		exphull.add(new Point2D(9,1));
		exphull.add(new Point2D(12,2));
		exphull.add(new Point2D(20,5));
		exphull.add(new Point2D(18,7));
		exphull.add(new Point2D(7,9));
		exphull.add(new Point2D(1,7));
		assertEquals(exphull,LocalRepair.getConvexHull(points));
	}
	
	
	@Test
	void gardenofroses_jarviswrap() throws FileNotFoundException {
		Scanner in = new Scanner(new File("in\\gardenofrosesin.txt"));
		Scanner out = new Scanner(new File("out\\gardenofrosesout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String res = out.next();
			String solved = solvegardenofroses_jarviswrap(in);
			assertEquals(res,solved,"Test case " + i + " failed");
		}
		
		in.close();
		out.close();
	}
	
	@Test
	void gardenofroses_localrepair() throws FileNotFoundException {
		Scanner in = new Scanner(new File("in\\gardenofrosesin.txt"));
		Scanner out = new Scanner(new File("out\\gardenofrosesout.txt"));
		
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String res = out.next();
			String solved = solvegardenofroses_localrepair(in);
			assertEquals(res,solved,"Test case " + i + " failed");
		}
		
		in.close();
		out.close();
	}
	
	private String solvegardenofroses_jarviswrap(Scanner in) {
		int n = in.nextInt();
		int m = in.nextInt();
		Point2D[] weeds = new Point2D[m];
		HashSet<Point2D> roses = new HashSet<Point2D>();
		for (int i = 0; i < n; i++) {
			roses.add(new Point2D(in.nextInt(),in.nextInt()));
		}
        for (int i = 0; i < m; i++) {
            weeds[i] = new Point2D(in.nextInt(),in.nextInt());
          }
		ArrayList<Point2D> convexhull = JarvisWrap.getConvexHull(roses);
		
        String toReturn = "";
        for (int i = 0; i < m; i++) {
          toReturn += (JarvisWrap.inHull(weeds[i], convexhull)) ? "y" : "n";
        }
        
        return toReturn;
	}
	
	private String solvegardenofroses_localrepair(Scanner in) {
		int n = in.nextInt();
		int m = in.nextInt();
		Point2D[] weeds = new Point2D[m];
		HashSet<Point2D> roses = new HashSet<Point2D>();
		for (int i = 0; i < n; i++) {
			roses.add(new Point2D(in.nextInt(),in.nextInt()));
		}
        for (int i = 0; i < m; i++) {
            weeds[i] = new Point2D(in.nextInt(),in.nextInt());
          }
		ArrayList<Point2D> convexhull = LocalRepair.getConvexHull(roses);
		
        String toReturn = "";
        for (int i = 0; i < m; i++) {
          toReturn += (JarvisWrap.inHull(weeds[i], convexhull)) ? "y" : "n";
        }
        
        return toReturn;
	}

}
