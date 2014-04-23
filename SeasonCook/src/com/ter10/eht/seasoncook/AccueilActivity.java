package com.ter10.eht.seasoncook;

import java.util.Calendar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

public class AccueilActivity extends ActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		Calendar curDate = Calendar.getInstance(); 
		String curSaison = getSaison(curDate.get(Calendar.DAY_OF_MONTH), curDate.get(Calendar.MONTH));
		setThemeSaison(curSaison);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		
		/*mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
        		FragmentTabIngredients.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"),
        		FragmentTabIngredients.class, null);*/
		
		/*Log.d("Yop","1");
		TabHost tabs = (TabHost)findViewById(android.R.id.tabhost);
		Log.d("Yop","2");
	    tabs.setup();
	    Log.d("Yop","3");
	    //tab fruits
		TabHost.TabSpec fruitsTab = tabs.newTabSpec("fruits");
		fruitsTab.setContent(R.id.fruits);
		fruitsTab.setIndicator("Fruit");
	    tabs.addTab(fruitsTab);
	    Log.d("Yop","4");
	    
	    //tab legumes
	    TabHost.TabSpec legumesTab = tabs.newTabSpec("legumes");
	    legumesTab.setContent(R.id.legumes);
	    legumesTab.setIndicator("Legumes");
	    tabs.addTab(legumesTab);
	    Log.d("Yop","5");*/
	    
	    /*TabHost mTabHost = (TabHost)findViewById(android.R.id.tabhost);
	    mTabHost.setup();
	    
	    mTabHost.addTab(mTabHost.newTabSpec("tab_test1").setIndicator("TAB 1").setContent(R.id.fruits));
	    mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("TAB 2").setContent(R.id.legumes));

	    mTabHost.setCurrentTab(0);*/
	    
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_accueil,
					container, false);
			return rootView;
		}
	}

	/* Permet d'obtenir la saison en fonction du jour et du mois */
	public String getSaison(int day, int month){
		String saison = "";
		if(month == 0 || month == 1 || (month == 2 && day <= 20) || (month == 11 && day > 21)){
			saison = "Hiver";
		}else if((month == 2 && day > 20) || month == 3 || month == 4 || (month == 5 && day <= 20)){
			saison = "Printemps";
		}else if((month == 5 && day > 20) || month == 6 || month == 7 || (month == 8 && day <= 22)){
			saison = "Eté";
		}else if((month == 8 && day > 22) || month == 9 || month == 10 || (month == 11 && day <= 21)){
			saison = "Automne";
		}else{
			saison = "Invalide";
		}
		return saison;
	}
	
	/* Theme en fonction de la saison */
	public void setThemeSaison(String curSaison){
		if(curSaison == "Printemps"){
			setTheme(R.style.Theme_Printemps);
		}else if(curSaison == "Eté"){
			setTheme(R.style.Theme_Ete);
		}else if(curSaison == "Automne"){
			setTheme(R.style.Theme_Automne);
		}else if(curSaison == "Hiver"){
			setTheme(R.style.Theme_Hiver);
		}
	}
	
}
