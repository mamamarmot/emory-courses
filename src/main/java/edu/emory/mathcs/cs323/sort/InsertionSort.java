/**
 * Copyright 2014, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.cs323.sort;



/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSort<T>
{
	@Override
	public void sort(T[] array)
	{
		int i, j, len = array.length;
		
		for (i=1; i<len; i++)
			for (j=i; j>0 && compareTo(array, j, j-1) < 0; j--)
				swap(array, j, j-1);
	}
}
