package com.puneet.chugh;

public class Node implements Comparable<Node>{

	int x,y;
	double g,h;
	public Node(int x, int y){
		this.x = x;
		this.y= y;
	}

	public void setG(double dist){
		g = dist;
	} 
	
	public void setH(double dist){
		h = dist;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public double getG(){
		return g;
	}
	
	public double getH(){
		return h;
	}

	public boolean equals(Object obj){
		
		if(this == obj)
			return true;
		
		if(obj==null || !(obj instanceof Node))
			return false;

		Node node = (Node) obj;
		return x==node.getX() && 
			y==node.getY();
	}
	
	public double getDistance(){
		return g+h;
	}
	
	public int hashCode(){

		int result = 17;
		result = 31*result + 17*x;
		result = 17*result + 31*y;
		return result;
	}

	public int compareTo(Node node){

		double diff = getDistance() - 
			(node.getDistance());
		
		return (diff>0.0) ? 1 : 
				(diff<0.0) ? -1 : 0; 
	}

}
