/**   
 * Copyright 2009-2011 Sönke Sothmann, Steffen Schäfer and others
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.gwtgl.array;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.googlecode.gwtgl.util.JsArrayUtil;

/**
 * @author Steffen Schäfer
 *
 */
public class Float32Array extends TypedArray<Float32Array> {
	
	/**
	 * protected standard constructor as specified by {@link JavaScriptObject}.
	 */
	protected Float32Array() {
		super();
	}
	
	/**
	 * Creates a new instance of the {@link TypedArray} of the given length in
	 * values. All values are set to 0.
	 * 
	 * @param length the length in values of the type used by this {@link TypedArray}
	 * @return the created {@link TypedArray}.
	 */
	public static native Float32Array create(int length) /*-{
		return new Float32Array(length);
	}-*/;
	
	/**
	 * Creates a new instance of the {@link TypedArray} of the same length as
	 * the given {@link TypedArray}. The values are set to the values of the
	 * given {@link TypedArray}.
	 * 
	 * @param array the {@link TypedArray} to get the values from
	 * @return the created {@link TypedArray}.
	 */
	public static native Float32Array create(Float32Array array) /*-{
		return new Float32Array(array);
	}-*/;
	
	/**
	 * Creates a new instance of the {@link TypedArray} of the length of the
	 * given array in values. The values are set to the values of the given
	 * array.
	 * 
	 * @param array
	 *            the array to get the values from
	 * @return the created {@link TypedArray}.
	 */
	public static Float32Array create(float[] array) {
		if(GWT.isScript()) {
			return innerCreate(array);
		}
		return innerCreate(JsArrayUtil.wrapArray(array));
	};
	
	private static native Float32Array innerCreate(float[] array) /*-{
		return new Float32Array(array);
	}-*/;
	
	private static native Float32Array innerCreate(JsArrayNumber array) /*-{
		return new Float32Array(array);
	}-*/;
	
	/**
	 * Creates a new instance of the {@link TypedArray} using the given
	 * {@link ArrayBuffer} to read/write values from/to.
	 * 
	 * @param buffer
	 *            the underlying {@link ArrayBuffer} of the newly created
	 *            {@link TypedArray}.
	 * @return the created {@link TypedArray}.
	 */
	public static native Float32Array create(ArrayBuffer buffer) /*-{
		return new Float32Array(buffer);
	}-*/;
	
	/**
	 * Creates a new instance of the {@link TypedArray} using the given
	 * {@link ArrayBuffer} to read/write values from/to.
	 * 
	 * The {@link TypedArray} is created using the byteOffset to specify the
	 * starting point (in bytes) of the {@link TypedArray} relative to the
	 * beginning of the underlying {@link ArrayBuffer}. The byte offset must
	 * match (multiple) the value length of this {@link TypedArray}.
	 * 
	 * if the byteLength is not valid for the given {@link ArrayBuffer}, an
	 * exception is thrown
	 * 
	 * @param buffer
	 *            the underlying {@link ArrayBuffer} of the newly created
	 *            {@link TypedArray}.
	 * @param byteOffset
	 *            the offset relative to the beginning of the ArrayBuffer
	 *            (multiple of the value length of this {@link TypedArray})
	 * @return the newly created {@link TypedArray}.
	 */
	public static native Float32Array create(ArrayBuffer buffer, int byteOffset) /*-{
		return new Float32Array(buffer, byteOffset);
	}-*/;
	
	/**
	 * Creates a new instance of the {@link TypedArray} using the given
	 * {@link ArrayBuffer} to read/write values from/to.
	 * 
	 * The {@link TypedArray} is created using the byteOffset and length to specify the
	 * start and end (in bytes) of the {@link TypedArray} relative to the
	 * beginning of the underlying {@link ArrayBuffer}. The byte offset must
	 * match (multiple) the value length of this {@link TypedArray}.
	 * The length is in values of the type of the {@link TypedArray}
	 * 
	 * if the byteLength or length is not valid for the given {@link ArrayBuffer}, an
	 * exception is thrown
	 * 
	 * @param buffer
	 *            the underlying {@link ArrayBuffer} of the newly created
	 *            {@link TypedArray}.
	 * @param byteOffset
	 *            the offset relative to the beginning of the ArrayBuffer
	 *            (multiple of the value length of this {@link TypedArray})
	 * @param length the length of the {@link TypedArray} in vales.
	 * @return the newly created {@link TypedArray}.
	 */
	public static native Float32Array create(ArrayBuffer buffer, int byteOffset, int length) /*-{
		return new Float32Array(buffer, byteOffset, length);
	}-*/;
	
	/**
	 * Reads the value at the given index. The index is based on the value length
	 * of the type used by this {@link TypedArray}.
	 * Accessing an index that doesn't exist will cause an exception.
	 * 
	 * 
	 * @param index the index relative to the beginning of the TypedArray.
	 * @return the value at the given index
	 */
	public final native float get(int index) /*-{
		return this[index];
	}-*/;
	
	/**
	 * Writes the given value at the given index. The index is based on the
	 * value length of the type used by this {@link TypedArray}. Accessing an index that
	 * doesn't exist will cause an exception.
	 * 
	 * Values that are out of the range for the type used by this TypedAray
	 * are silently casted to be in range.
	 * 
	 * @param index the index relative to the beginning of the TypedArray.
	 * @param value the new value to set
	 */
	public final native void set(int index, float value) /*-{
		this[index] = value;
	}-*/;
	
	/**
	 * Writes multiple values to the TypedArray using the values of the given
	 * Array.
	 * 
	 * @param array
	 *            an array containing the new values to set.
	 */
	public final void set(float[] array) {
		if(GWT.isScript()) {
			innerSet(array);
		}
		innerSet(JsArrayUtil.wrapArray(array));
	};
	
	private static native void innerSet(float[] array) /*-{
		this.set(array);
	}-*/;
	
	private static native void innerSet(JsArrayNumber array) /*-{
		this.set(array);
	}-*/;
	
	/**
	 * Writes multiple values to the TypedArray using the values of the given
	 * Array. Writes the values beginning at the given offset.
	 * 
	 * @param array
	 *            an array containing the new values to set.
	 * @param offset the offset relative to the beginning of the TypedArray.
	 */
	public final void set(float[] array, int offset) {
		if(GWT.isScript()) {
			innerSet(array, offset);
		}
		innerSet(JsArrayUtil.wrapArray(array), offset);
	};
	
	private static native void innerSet(float[] array, int offset) /*-{
		this.set(array, offset);
	}-*/;
	
	private static native void innerSet(JsArrayNumber array, int offset) /*-{
		this.set(array, offset);
	}-*/;

}
