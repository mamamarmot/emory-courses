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
package edu.emory.mathcs.utils;

/** @author Jinho D. Choi ({@code jinho.choi@emory.edu}) */
public class IndexedItem<T>
{
	public T   item;
	public int index;
	
	public IndexedItem(T item, int index)
	{
		set(item, index);
	}
	
	public void set(T item, int index)
	{
		this.item  = item;
		this.index = index;
	}
}
