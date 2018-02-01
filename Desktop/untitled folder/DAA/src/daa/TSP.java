package daa;

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.*;

public class TSP {
	public JFrame frm;
	public int numberOfNodes;
	public Stack<Integer> stack;
	int totalcost;
	int visited[];
	int cindex;
	int cost;
	public int[][] adjacencyMatrix = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 47, 17, 20, 41, 33 },
			{ 0, 71, 0, 70, 55, 9, 29 }, { 0, 33, 88, 0, 45, 11, 23 }, { 0, 67, 45, 17, 0, 22, 33 },
			{ 0, 1, 69, 29, 24, 0, 10 }, { 0, 93, 57, 13, 55, 10, 0 } };

	// We can also create a 2D array with random cost between cities.
	public TSP(JFrame frame,int totalcost1, int[] city, int index) {
		stack = new Stack<Integer>();
		totalcost = totalcost1;
		visited = city;
		cindex = index;
		frm=frame;
		cost=totalcost1;
	}

	public void calculate() {
		numberOfNodes = 6;
		visited[cindex] = 1;
		stack.push(cindex);
		int element, dst = 0, i;
		int min = Integer.MAX_VALUE;
		boolean minFlag = false;

		while (!stack.isEmpty()) {
			element = stack.peek();
			i = 1;
			min = Integer.MAX_VALUE;
			while (i <= numberOfNodes) {
				if (adjacencyMatrix[element][i] > 0 && visited[i] == 0) {
					if (min > adjacencyMatrix[element][i]) {
						min = adjacencyMatrix[element][i];
						dst = i;
						minFlag = true;
					}
				}
				i++;
			}
			if (minFlag) {
				visited[dst] = 1;
				System.out.println("City Cost=  " + adjacencyMatrix[element][dst]);
				//System.out.println("Cost Before = " + totalcost);
				totalcost = totalcost - adjacencyMatrix[element][dst];
				//System.out.println("Cost After = " + totalcost);
				stack.push(dst);

				minFlag = false;
				continue;
			}
			stack.pop();

		}
		totalcost-=adjacencyMatrix[dst][cindex];
		if(totalcost>=0)
		{
			JOptionPane.showMessageDialog(frm,"The Trip is possible and you save Rs. "+totalcost+" from your budget.\nHappy Journey!","ESTIMATE",JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(frm,"The Trip exceeds your budget by Rs. "+(totalcost*(-1)),"ESTIMATE",JOptionPane.INFORMATION_MESSAGE);
		}
		

	}
}