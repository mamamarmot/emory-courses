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
package edu.emory.mathcs.cs323.search;

import java.util.List;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class BinarySearch<T extends Comparable<T>> implements ISearch<T>
{
	/**
	 * @param list a list sorted in ascending order.
	 * @return the index of the specific item in the list if exists; otherwise, -1.
	 */
	public int search(List<T> list, T key)
	{
		return searchAux(list, key, 0, list.size()-1); 
	}
	
	/**
	 * @param beginIndex the index of the first key to be searched (inclusive).
	 * @param endIndex the index of the last key to be searched (inclusive). 
	 */
	int searchAux(List<T> list, T key, int beginIndex, int endIndex)
	{
		if (beginIndex == endIndex)
			return key.equals(list.get(beginIndex)) ? beginIndex : -1;
		
		int middleIndex = beginIndex + (endIndex - beginIndex) / 2;
		int diff = key.compareTo(list.get(middleIndex));
		
		if (diff > 0)
			return searchAux(list, key, middleIndex+1, endIndex);
		else if (diff < 0)
			return searchAux(list, key, beginIndex, middleIndex-1);
		else
			return middleIndex;
	}
}
