package com.df3n5.gwtproc.client.util.mesh;

/**
 * Class that holds a mesh's data using indices
 * @author Sönke Sothmann
 */
public class IndexedMesh extends Mesh {
	
	/**
	 * Indices of this IndexedMesh
	 */
	protected int[] indices;
	
	/**
	 * Returns the indices for this IndexedMesh.
	 * 
	 * @return the indices
	 */
	public int[] getIndices() {
		return indices;
	}
	
}
