package com.df3n5.gwtproc.client.demos.bumpmapping.loading.proc;

import java.util.ArrayList;

class Plane extends Entity {
	int xMin, zMin, xMax, zMax, y;

	public Plane(int modelType, int xMin, int zMin, int xMax, int zMax, int y) {
		super(Entity.PLANE_TYPE, modelType, xMin, zMin);
		this.xMin = xMin;
		this.zMin = zMin;
		this.xMax = xMax;
		this.zMax = zMax;
		this.y = y;
	}

	public void generateTriangles()
	{
		//Two triangles : 
		//           (xMax, y, zMax)
		// * ------- * 
		// | \       |
		// |  \      |
		// |   \     |
		// |    \    |
		// |     \   |
		// |      \  |
		// |       \ |
		// * ------- *
		//(xMin, y, zMin)
		ArrayList<Triangle> res = new ArrayList<Triangle>();
		res.add(new Triangle(xMin,y,zMax, xMin,y,zMin, xMax,y,zMin));
		res.add(new Triangle(xMin,y,zMax, xMax,y,zMax, xMax,y,zMin));

		this.triangles = res;
	}

	public void generateTexCoords()
	{
		ArrayList<Point2> res = new ArrayList<Point2>();
		float amount = 6.0f;
		res.add(new Point2(0,amount));
		res.add(new Point2(0,0));
		res.add(new Point2(amount,0));

		res.add(new Point2(0,amount));
		res.add(new Point2(amount,amount));
		res.add(new Point2(amount,0));

		this.texCoords = res;
	}

	public void generateNormals()
	{
		ArrayList<Vector3> res = new ArrayList<Vector3>();
		Vector3 normal;
		if(y <= 1.0){
			normal = new Vector3(0,1,0);
		}
		else
		{
			normal = new Vector3(0,-1,0);
		}

		res.add(normal);
		res.add(normal);
		res.add(normal);
		res.add(normal);
		res.add(normal);
		res.add(normal);

		this.normals = res;
	}

} //End Plane
