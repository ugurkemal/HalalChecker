package org.hc;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SpecialAdapter extends SimpleAdapter {
	private int[] colors = new int[] { 0xF000CF00, 0xF0EE0001 };

	public SpecialAdapter(Context context, 
			List<? extends Map<String, String>> items, 
			int resource, 
			String[] from, 
			int[] to) {
		super(context, items, resource, from, to);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	  View view = super.getView(position, convertView, parent);
	  
	  ingredient ing = (ingredient)this.getItem(position);
	  TextView tv1 = (TextView)view.findViewById(android.R.id.text1);
	  TextView tv2 = (TextView)view.findViewById(android.R.id.text2);

	  if (ing != null){
		  tv1.setTextColor(colors[ing.color]);
		  tv2.setTextColor(colors[ing.color]);
	  }
	  
	  return view;
	}
}
