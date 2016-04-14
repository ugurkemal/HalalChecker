package org.hc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.EditText;


public class main extends ListActivity {
	SpecialAdapter adapter = null;
	EditText filter = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     	LicenseAgreement.showLicenseAgreement(this);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_title);
        setNewContentView(0);
        filter = (EditText) findViewById(R.id.search_box);
        filter.addTextChangedListener(filterTextWatcher);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	return true;
    }
    
	// This method is called once the menu is selected
	@Override	
	public boolean onOptionsItemSelected(MenuItem item) {
		filter.setText("");
		
		switch (item.getItemId()) {
			case R.id.item04:
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("About Halal Checker");
				builder.setIcon(R.drawable.ic_launcher_halalchecker);
				String versionInfo = "";
				PackageInfo pInfo;
				try {
					pInfo = this.getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_META_DATA);
					versionInfo = pInfo.versionName;
				} catch (NameNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String versionString = String.format("Version: %s", versionInfo);
				String url = "Visit http://www.halalchecker.com";
				String email = "Support support@halalchecker.com";
				String company = "Active Apps";
				builder.setMessage(versionString + "\n" + url + "\n" + email + "\nCompany: " + company + "\n" +
						   "Disclaimer:\n" + 
						   "1. Used terms in this disclaimer:\n" +
						   "	* Authors: the authors of this mobile application;\n" +
						   "	* Use(s): all possible actions;\n" +
						   "	* You: the user of this mobile application;\n" +
						   "	* Content: all content available in this mobile application;\n" +
						   "2. The following applies to the screens you are about to view.\n" +
						   "3. The content is gathered by the authors with the utmost care, yet, the authors assume no liability for any inaccuracies in the displayed.\n" +
						   "4. In the mobile application, an ingredient can either be marked as 'halal' or 'not halal'. 'Halal' should be interpreted as 'The origin of this ingredient is probably halal' and 'not halal' should be interpreted as 'There is a probability that the origin of this ingredient is not halal'. Authors of this software disclaim that they are an authority in giving of fatwa’s, so this characterization is not based on any fatwa, but is based on personal research of scientific resources and other resources on the World Wide Web. For the assurance of an ingredient being 'halal' or 'not halal', you need to consult the manufacturer of that ingredient.\n" +
						   "5. Unauthorized or improper use of the content or parts thereof infringe upon intellectual property rights.\n" +
						   "6. Permission to use the displayed content or parts of it in publicly accessible locations should be requested in writing to us.\n");

				// add a neutral button to the alert box and assign a click listener
				builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
	 
	                // click listener on the alert box
	                public void onClick(DialogInterface arg0, int arg1) {
	                    // the button was clicked
	                	arg0.cancel();
	                }
	            });
	 
	            // show it
				builder.show();

				break;
			case R.id.item03:
				setNewContentView(0);
				break;
			case R.id.item02:
				setNewContentView(2);
				break;
			case R.id.item01:
				setNewContentView(1);
				break;
			case R.id.item05:
				this.finish();
				break;

		}
		return true;
	}
	
	private TextWatcher filterTextWatcher = new TextWatcher() {

	    public void afterTextChanged(Editable s) {
	    }

	    public void beforeTextChanged(CharSequence s, int start, int count,
	            int after) {
	    }

	    public void onTextChanged(CharSequence s, int start, int before,
	            int count) {
	        adapter.getFilter().filter(s);
	    }

	};

	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    filter.removeTextChangedListener(filterTextWatcher);
	}
	
   private void setNewContentView(int aOption){
       // Create our own version of the list adapter
       List<ingredient> ingredienten = getData(aOption);
       adapter = new SpecialAdapter(this, ingredienten,
           android.R.layout.simple_list_item_2, new String[] {
       		ingredient.KEY_NAME, ingredient.KEY_ENUMMER }, new int[] {
             android.R.id.text1, android.R.id.text2 });

       setListAdapter(adapter);
   }
   
   private List<ingredient> getData(int aOption) {
    	XmlPullParser parser= getBaseContext().getResources().getXml(R.xml.ingredienten_eng); 
    	ArrayList<ingredient> ingredienten = new ArrayList<ingredient>();

    	try {
			while (parser.next() != XmlPullParser.END_DOCUMENT) {
				String tname = parser.getName();
				String name = "";
				String enummer = "";
				int color = -1;

				if((tname != null) && tname.equals("ingredient")) {
					int size = parser.getAttributeCount();
					for(int i = 0; i < size; i++) {
						String attrName = parser.getAttributeName(i);
						String attrValue = parser.getAttributeValue(i);

						if((attrName != null) && attrName.equals("name")) {
							name = attrValue;
						} 
						else if ((attrName != null) && attrName.equals("enummer")) {
							if (!attrValue.equals(""))
								enummer = "E" + attrValue;
							else
								enummer = attrValue;
							
						}
						else if ((attrName != null) && attrName.equals("moslims")) {
							color = Integer.valueOf(attrValue).intValue();
						}
					}
					
					if (name != "") {
						switch(aOption) {
							case 0:
								ingredienten.add(new ingredient(name, enummer, color));
								break;
							case 1:
								if (color == 0 )
									ingredienten.add(new ingredient(name, enummer, color));
								break;
							case 2:
								if (color == 1 )
									ingredienten.add(new ingredient(name, enummer, color));
								break;
						}
						
					}
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(ingredienten);
        return ingredienten;
      }
}
