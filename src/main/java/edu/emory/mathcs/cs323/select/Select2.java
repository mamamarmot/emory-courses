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
package edu.emory.mathcs.cs323.select;

import java.util.ArrayList;
import java.util.List;

import edu.emory.mathcs.utils.IndexedItem;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class Select2<T extends Comparable<T>> extends AbstractSelect<T>
{
	@Override
	public T max(List<T> list, int k)
	{
		List<T> copy = new ArrayList<>(list);
		IndexedItem<T> max = null;
		
		for (int i=0; i<k; i++)
		{
			max = max(copy);
			copy.remove(max.index);
		}
		
		return max.item;
	}
	
	/** @return the first item with the maximum value in the list and its index. */
	IndexedItem<T> max(List<T> list)
	{
		IndexedItem<T> max = new IndexedItem<>(list.get(0), 0);
		T item;
		
		for (int i=1; i<list.size(); i++)
		{
			item = list.get(i);
			
			if (item.compareTo(max.item) > 0)
				max.set(item, i);
		}
		
		return max;
	}
}
