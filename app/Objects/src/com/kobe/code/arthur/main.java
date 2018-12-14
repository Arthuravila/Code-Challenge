package com.kobe.code.arthur;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends android.support.v7.app.AppCompatActivity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new BA(this.getApplicationContext(), null, null, "com.kobe.code.arthur", "com.kobe.code.arthur.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "com.kobe.code.arthur", "com.kobe.code.arthur.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "com.kobe.code.arthur.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            main mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }

public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvvv7 = null;
public de.amberhome.objects.appcompat.ACToolbarLightWrapper _toolbar = null;
public de.amberhome.objects.appcompat.ACSearchViewWrapper _vvvvvvvvvvvv5 = null;
public de.amberhome.objects.appcompat.ACMenuItemWrapper _vvvvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlmain = null;
public com.kobe.code.arthur.customlistview _clvupcoming = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgupcomingclvposter = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblupcomingclvname = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblupcomingclvrelease = null;
public anywheresoftware.b4a.objects.LabelWrapper _lblupcomingclvgenre = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnldetails = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _imgdetailsmovie = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldetailsname = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldetailrelease = null;
public anywheresoftware.b4a.objects.LabelWrapper _lbldetailsgenre = null;
public com.kobe.code.arthur.customlistview _clvdetailsoverview = null;
public static long _vvvvvvvvvvvvvvv1 = 0L;
public static int _vvvvvvvvvvvvvvv2 = 0;
public static int _vvvvvvvvvvvvvvv3 = 0;
public anywheresoftware.b4a.objects.collections.Map _vvvvvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.collections.Map _vvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.PanelWrapper _vvvvvvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _vvvvvvvvvvvvvvvv6 = null;
public anywheresoftware.b4a.objects.PanelWrapper _pnlsearch = null;
public com.kobe.code.arthur.customlistview _clvsearch = null;
public com.kobe.code.arthur.starter _vvvvvv7 = null;
public com.kobe.code.arthur.httputils2service _vvvvvv0 = null;
public com.kobe.code.arthur.getimage _vvvvvvv1 = null;

public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}
public static String  _activity_create(boolean _firsttime) throws Exception{
 //BA.debugLineNum = 65;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
 //BA.debugLineNum = 66;BA.debugLine="Activity.LoadLayout(\"Main\")";
mostCurrent._activity.LoadLayout("Main",mostCurrent.activityBA);
 //BA.debugLineNum = 69;BA.debugLine="ToolBar.Title = Application.LabelName";
mostCurrent._toolbar.setTitle(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Application.getLabelName()));
 //BA.debugLineNum = 70;BA.debugLine="ToolBar.TitleTextColor = Colors.White";
mostCurrent._toolbar.setTitleTextColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 71;BA.debugLine="ToolBar.Color = Colors.RGB(92,92,92)";
mostCurrent._toolbar.setColor(anywheresoftware.b4a.keywords.Common.Colors.RGB((int) (92),(int) (92),(int) (92)));
 //BA.debugLineNum = 72;BA.debugLine="ToolBar.InitMenuListener";
mostCurrent._toolbar.InitMenuListener();
 //BA.debugLineNum = 73;BA.debugLine="sv.Initialize(\"Search\")";
mostCurrent._vvvvvvvvvvvv5.Initialize(mostCurrent.activityBA,"Search");
 //BA.debugLineNum = 74;BA.debugLine="sv.IconifiedByDefault = True";
mostCurrent._vvvvvvvvvvvv5.setIconifiedByDefault(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 76;BA.debugLine="Load_Intro";
_load_intro();
 //BA.debugLineNum = 77;BA.debugLine="End Sub";
return "";
}
public static String  _activity_createmenu(de.amberhome.objects.appcompat.ACMenuWrapper _menu) throws Exception{
 //BA.debugLineNum = 188;BA.debugLine="Sub Activity_CreateMenu(Menu As ACMenu)";
 //BA.debugLineNum = 189;BA.debugLine="Menu.Clear";
_menu.Clear();
 //BA.debugLineNum = 190;BA.debugLine="itemsearch = ToolBar.Menu.Add2(1, 1, \"Search\", Nu";
mostCurrent._vvvvvvvvvvvvvv7 = mostCurrent._toolbar.getMenu().Add2((int) (1),(int) (1),BA.ObjectToCharSequence("Search"),(android.graphics.drawable.Drawable)(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 191;BA.debugLine="itemsearch.SearchView=sv";
mostCurrent._vvvvvvvvvvvvvv7.setSearchView(mostCurrent._vvvvvvvvvvvv5);
 //BA.debugLineNum = 192;BA.debugLine="End Sub";
return "";
}
public static boolean  _activity_keypress(int _keycode) throws Exception{
 //BA.debugLineNum = 103;BA.debugLine="Sub Activity_KeyPress (KeyCode As Int) As Boolean";
 //BA.debugLineNum = 104;BA.debugLine="If KeyCode = KeyCodes.KEYCODE_BACK Then";
if (_keycode==anywheresoftware.b4a.keywords.Common.KeyCodes.KEYCODE_BACK) { 
 //BA.debugLineNum = 105;BA.debugLine="If pnlDetails.Visible Then";
if (mostCurrent._pnldetails.getVisible()) { 
 //BA.debugLineNum = 106;BA.debugLine="pnlDetails.Visible = False";
mostCurrent._pnldetails.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 107;BA.debugLine="itemsearch.Visible = True";
mostCurrent._vvvvvvvvvvvvvv7.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 108;BA.debugLine="clvDetailsOverview.Clear";
mostCurrent._clvdetailsoverview._vvvvvvv5();
 //BA.debugLineNum = 109;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else if(mostCurrent._pnlsearch.getVisible()) { 
 //BA.debugLineNum = 111;BA.debugLine="pnlSearch.Visible = False";
mostCurrent._pnlsearch.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 112;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 }else {
 //BA.debugLineNum = 115;BA.debugLine="Close_App";
_close_app();
 //BA.debugLineNum = 116;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 };
 //BA.debugLineNum = 119;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 //BA.debugLineNum = 120;BA.debugLine="End Sub";
return false;
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
 //BA.debugLineNum = 85;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
 //BA.debugLineNum = 87;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub Activity_Resume";
 //BA.debugLineNum = 82;BA.debugLine="End Sub";
return "";
}
public static void  _close_app() throws Exception{
ResumableSub_Close_App rsub = new ResumableSub_Close_App(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Close_App extends BA.ResumableSub {
public ResumableSub_Close_App(com.kobe.code.arthur.main parent) {
this.parent = parent;
}
com.kobe.code.arthur.main parent;
int _result = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 125;BA.debugLine="Msgbox2Async(\"Do you really want to exit the appl";
anywheresoftware.b4a.keywords.Common.Msgbox2Async(BA.ObjectToCharSequence("Do you really want to exit the application?"),BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),"Yes","Cancel","",(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.Null)),processBA,anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 126;BA.debugLine="Wait For Msgbox_Result (Result As Int)";
anywheresoftware.b4a.keywords.Common.WaitFor("msgbox_result", processBA, this, null);
this.state = 7;
return;
case 7:
//C
this.state = 1;
_result = (Integer) result[0];
;
 //BA.debugLineNum = 127;BA.debugLine="If Result = DialogResponse.POSITIVE Then";
if (true) break;

case 1:
//if
this.state = 6;
if (_result==anywheresoftware.b4a.keywords.Common.DialogResponse.POSITIVE) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 //BA.debugLineNum = 128;BA.debugLine="Sleep(0)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (0));
this.state = 8;
return;
case 8:
//C
this.state = 6;
;
 //BA.debugLineNum = 129;BA.debugLine="Activity.Finish";
parent.mostCurrent._activity.Finish();
 if (true) break;

case 5:
//C
this.state = 6;
 //BA.debugLineNum = 131;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 6:
//C
this.state = -1;
;
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _msgbox_result(int _result) throws Exception{
}
public static String  _clvupcoming_itemclick(int _index,Object _value) throws Exception{
 //BA.debugLineNum = 427;BA.debugLine="Sub clvUpcoming_ItemClick (Index As Int, Value As";
 //BA.debugLineNum = 429;BA.debugLine="createMovieDetailsView(Value)";
_vvvvvvvvvvvvvv0(_value);
 //BA.debugLineNum = 430;BA.debugLine="End Sub";
return "";
}
public static String  _clvupcoming_reachend() throws Exception{
 //BA.debugLineNum = 471;BA.debugLine="Sub clvUpcoming_ReachEnd";
 //BA.debugLineNum = 472;BA.debugLine="If DateTime.Now < lastReachEndTime + 3 * DateTime";
if (anywheresoftware.b4a.keywords.Common.DateTime.getNow()<_vvvvvvvvvvvvvvv1+3*anywheresoftware.b4a.keywords.Common.DateTime.TicksPerSecond) { 
if (true) return "";};
 //BA.debugLineNum = 473;BA.debugLine="lastReachEndTime = DateTime.Now";
_vvvvvvvvvvvvvvv1 = anywheresoftware.b4a.keywords.Common.DateTime.getNow();
 //BA.debugLineNum = 476;BA.debugLine="If lastPage >= totalPages Then Return";
if (_vvvvvvvvvvvvvvv2>=_vvvvvvvvvvvvvvv3) { 
if (true) return "";};
 //BA.debugLineNum = 478;BA.debugLine="ProgressDialogShow2(\"Loading...\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 480;BA.debugLine="lastPage = lastPage + 1";
_vvvvvvvvvvvvvvv2 = (int) (_vvvvvvvvvvvvvvv2+1);
 //BA.debugLineNum = 483;BA.debugLine="getUpcoming(lastPage)";
_vvvvvvvvvvvvvvv4(_vvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 484;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvvvvvvvvvv5(String _overviewinfo) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
anywheresoftware.b4a.objects.LabelWrapper _lbltext = null;
 //BA.debugLineNum = 452;BA.debugLine="Sub createMovieDetailsOverview(overviewInfo As Str";
 //BA.debugLineNum = 453;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvvvvvvvv7.CreatePanel(processBA,"");
 //BA.debugLineNum = 454;BA.debugLine="p.Color = xui.Color_Transparent";
_p.setColor(_vvvvvvvvvvvvv7.Color_Transparent);
 //BA.debugLineNum = 456;BA.debugLine="Dim lblText As Label";
_lbltext = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 457;BA.debugLine="lblText.Initialize(\"\")";
_lbltext.Initialize(mostCurrent.activityBA,"");
 //BA.debugLineNum = 458;BA.debugLine="lblText.Text = overviewInfo";
_lbltext.setText(BA.ObjectToCharSequence(_overviewinfo));
 //BA.debugLineNum = 459;BA.debugLine="lblText.TextColor = 0xFF3C3C3C";
_lbltext.setTextColor((int) (0xff3c3c3c));
 //BA.debugLineNum = 460;BA.debugLine="p.AddView(lblText, 1%x, 2%y, 80%x, 30%y)";
_p.AddView((android.view.View)(_lbltext.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (1),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (80),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 //BA.debugLineNum = 462;BA.debugLine="lblText.Height = Starter.su.MeasureMultilineTextH";
_lbltext.setHeight((int) (mostCurrent._vvvvvv7._vv3.MeasureMultilineTextHeight((android.widget.TextView)(_lbltext.getObject()),BA.ObjectToCharSequence(_lbltext.getText()))+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (4),mostCurrent.activityBA)));
 //BA.debugLineNum = 464;BA.debugLine="p.SetLayoutAnimated(0, 0%x, 0%y, 100%x, lblText.T";
_p.SetLayoutAnimated((int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),(int) (_lbltext.getTop()+_lbltext.getHeight()+anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (2),mostCurrent.activityBA)));
 //BA.debugLineNum = 466;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 467;BA.debugLine="End Sub";
return null;
}
public static String  _vvvvvvvvvvvvvv0(Object _value) throws Exception{
anywheresoftware.b4a.objects.collections.List _params = null;
 //BA.debugLineNum = 434;BA.debugLine="Sub createMovieDetailsView(Value As Object)";
 //BA.debugLineNum = 435;BA.debugLine="itemsearch.Visible = False";
mostCurrent._vvvvvvvvvvvvvv7.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 436;BA.debugLine="itemsearch.ItemCollapsed = True";
mostCurrent._vvvvvvvvvvvvvv7.setItemCollapsed(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 438;BA.debugLine="Dim params As List : params.initialize";
_params = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 438;BA.debugLine="Dim params As List : params.initialize";
_params.Initialize();
 //BA.debugLineNum = 439;BA.debugLine="params = mapAuxMovieInfo.Get(Value)";
_params.setObject((java.util.List)(mostCurrent._vvvvvvvvvvvvvvv6.Get(_value)));
 //BA.debugLineNum = 441;BA.debugLine="lblDetailsName.Text = params.Get(0)";
mostCurrent._lbldetailsname.setText(BA.ObjectToCharSequence(_params.Get((int) (0))));
 //BA.debugLineNum = 442;BA.debugLine="lblDetailRelease.Text = params.Get(1)";
mostCurrent._lbldetailrelease.setText(BA.ObjectToCharSequence(_params.Get((int) (1))));
 //BA.debugLineNum = 443;BA.debugLine="lblDetailsGenre.Text = mapAuxGenres.Get(Value)'";
mostCurrent._lbldetailsgenre.setText(BA.ObjectToCharSequence(mostCurrent._vvvvvvvvvvvvvvv7.Get(_value)));
 //BA.debugLineNum = 444;BA.debugLine="CallSubDelayed3(GetImage,\"Baixa_Imagem\",imgDetail";
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(processBA,(Object)(mostCurrent._vvvvvvv1.getObject()),"Baixa_Imagem",(Object)(mostCurrent._imgdetailsmovie),(Object)(mostCurrent._vvvvvv7._v0+"/"+BA.ObjectToString(_params.Get((int) (2)))));
 //BA.debugLineNum = 445;BA.debugLine="clvDetailsOverview.Add(createMovieDetailsOverview";
mostCurrent._clvdetailsoverview._vvvvvvv2(_vvvvvvvvvvvvvvv5(BA.ObjectToString(_params.Get((int) (3)))),anywheresoftware.b4a.keywords.Common.Null);
 //BA.debugLineNum = 447;BA.debugLine="pnlDetails.SetVisibleAnimated(250, True)";
mostCurrent._pnldetails.SetVisibleAnimated((int) (250),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 448;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvvvvvvvvvv0(int _idmovie,String _namemovie,String _releasemovie,String _postermovieurl) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
 //BA.debugLineNum = 256;BA.debugLine="Sub createSearchItem(idMovie As Int, nameMovie As";
 //BA.debugLineNum = 257;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvvvvvvvv7.CreatePanel(processBA,"");
 //BA.debugLineNum = 258;BA.debugLine="p.SetLayoutAnimated(0, 0%x, 0%y, 100%x, 30%y)";
_p.SetLayoutAnimated((int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 //BA.debugLineNum = 259;BA.debugLine="p.LoadLayout(\"LayoutUpcomingClv\")";
_p.LoadLayout("LayoutUpcomingClv",mostCurrent.activityBA);
 //BA.debugLineNum = 260;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 262;BA.debugLine="lblUpcomingClvName.Text = nameMovie";
mostCurrent._lblupcomingclvname.setText(BA.ObjectToCharSequence(_namemovie));
 //BA.debugLineNum = 263;BA.debugLine="lblUpcomingClvRelease.Text = releaseMovie";
mostCurrent._lblupcomingclvrelease.setText(BA.ObjectToCharSequence(_releasemovie));
 //BA.debugLineNum = 265;BA.debugLine="CallSubDelayed3(GetImage,\"Baixa_Imagem\",imgUpcomi";
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(processBA,(Object)(mostCurrent._vvvvvvv1.getObject()),"Baixa_Imagem",(Object)(mostCurrent._imgupcomingclvposter),(Object)(mostCurrent._vvvvvv7._v0+"/"+_postermovieurl));
 //BA.debugLineNum = 267;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvvvvvvvvvvv1(int _idmovie,String _namemovie,String _releasemovie,String _postermovieurl,anywheresoftware.b4a.objects.collections.List _genrelist) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _i = 0;
 //BA.debugLineNum = 398;BA.debugLine="Sub createUpcomingItem(idMovie As Int, nameMovie A";
 //BA.debugLineNum = 399;BA.debugLine="Dim p As B4XView = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvvvvvvvv7.CreatePanel(processBA,"");
 //BA.debugLineNum = 400;BA.debugLine="p.SetLayoutAnimated(0, 0%x, 0%y, 100%x, 30%y)";
_p.SetLayoutAnimated((int) (0),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA));
 //BA.debugLineNum = 401;BA.debugLine="p.LoadLayout(\"LayoutUpcomingClv\")";
_p.LoadLayout("LayoutUpcomingClv",mostCurrent.activityBA);
 //BA.debugLineNum = 402;BA.debugLine="p.Color = Colors.White";
_p.setColor(anywheresoftware.b4a.keywords.Common.Colors.White);
 //BA.debugLineNum = 404;BA.debugLine="lblUpcomingClvName.Text = nameMovie";
mostCurrent._lblupcomingclvname.setText(BA.ObjectToCharSequence(_namemovie));
 //BA.debugLineNum = 405;BA.debugLine="lblUpcomingClvRelease.Text = releaseMovie";
mostCurrent._lblupcomingclvrelease.setText(BA.ObjectToCharSequence(_releasemovie));
 //BA.debugLineNum = 407;BA.debugLine="Try";
try { //BA.debugLineNum = 408;BA.debugLine="lblUpcomingClvGenre.Text = genreList.Get(0)";
mostCurrent._lblupcomingclvgenre.setText(BA.ObjectToCharSequence(_genrelist.Get((int) (0))));
 //BA.debugLineNum = 409;BA.debugLine="For i = 1 To genreList.Size - 2";
{
final int step9 = 1;
final int limit9 = (int) (_genrelist.getSize()-2);
_i = (int) (1) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
 //BA.debugLineNum = 410;BA.debugLine="lblUpcomingClvGenre.Text = lblUpcomingClvGenre.";
mostCurrent._lblupcomingclvgenre.setText(BA.ObjectToCharSequence(mostCurrent._lblupcomingclvgenre.getText()+", "+BA.ObjectToString(_genrelist.Get(_i))));
 }
};
 //BA.debugLineNum = 413;BA.debugLine="If genreList.Size > 1 Then lblUpcomingClvGenre.T";
if (_genrelist.getSize()>1) { 
mostCurrent._lblupcomingclvgenre.setText(BA.ObjectToCharSequence(mostCurrent._lblupcomingclvgenre.getText()+", "+BA.ObjectToString(_genrelist.Get((int) (_genrelist.getSize()-1)))));};
 } 
       catch (Exception e14) {
			processBA.setLastException(e14); //BA.debugLineNum = 416;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 };
 //BA.debugLineNum = 420;BA.debugLine="CallSubDelayed3(GetImage,\"Baixa_Imagem\",imgUpcomi";
anywheresoftware.b4a.keywords.Common.CallSubDelayed3(processBA,(Object)(mostCurrent._vvvvvvv1.getObject()),"Baixa_Imagem",(Object)(mostCurrent._imgupcomingclvposter),(Object)(mostCurrent._vvvvvv7._v0+"/"+_postermovieurl));
 //BA.debugLineNum = 422;BA.debugLine="Return p";
if (true) return _p;
 //BA.debugLineNum = 423;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper  _vvvvvvvvvvvvvvvv2(String _text,float _fontsize,int _fontcolor) throws Exception{
anywheresoftware.b4a.objects.PanelWrapper _p = null;
anywheresoftware.b4a.objects.B4XCanvas _cvs1 = null;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XFont _fnt = null;
anywheresoftware.b4a.objects.B4XCanvas.B4XRect _r = null;
int _baseline = 0;
anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper _b = null;
 //BA.debugLineNum = 514;BA.debugLine="Sub FontAwesomeToBitmap(Text As String, FontSize A";
 //BA.debugLineNum = 515;BA.debugLine="Dim xui As XUI";
_vvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 516;BA.debugLine="Dim P As Panel = xui.CreatePanel(\"\")";
_p = new anywheresoftware.b4a.objects.PanelWrapper();
_p.setObject((android.view.ViewGroup)(_vvvvvvvvvvvvv7.CreatePanel(processBA,"").getObject()));
 //BA.debugLineNum = 517;BA.debugLine="P.SetLayoutAnimated(0, 0, 0, 32dip, 32dip)";
_p.SetLayoutAnimated((int) (0),(int) (0),(int) (0),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)),anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (32)));
 //BA.debugLineNum = 518;BA.debugLine="Dim CVS1 As B4XCanvas";
_cvs1 = new anywheresoftware.b4a.objects.B4XCanvas();
 //BA.debugLineNum = 519;BA.debugLine="CVS1.Initialize(p)";
_cvs1.Initialize((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_p.getObject())));
 //BA.debugLineNum = 520;BA.debugLine="Dim Fnt As B4XFont = xui.CreateFont(Typeface.FONT";
_fnt = _vvvvvvvvvvvvv7.CreateFont(anywheresoftware.b4a.keywords.Common.Typeface.getFONTAWESOME(),_fontsize);
 //BA.debugLineNum = 521;BA.debugLine="Dim R As B4XRect = CVS1.MeasureText(Text, Fnt)";
_r = _cvs1.MeasureText(_text,_fnt);
 //BA.debugLineNum = 522;BA.debugLine="Dim BaseLine As Int = CVS1.TargetRect.CenterY - r";
_baseline = (int) (_cvs1.getTargetRect().getCenterY()-_r.getHeight()/(double)2-_r.getTop());
 //BA.debugLineNum = 523;BA.debugLine="CVS1.DrawText(Text, CVS1.TargetRect.CenterX, Base";
_cvs1.DrawText(processBA,_text,_cvs1.getTargetRect().getCenterX(),(float) (_baseline),_fnt,_fontcolor,BA.getEnumFromString(android.graphics.Paint.Align.class,"CENTER"));
 //BA.debugLineNum = 524;BA.debugLine="Dim B As B4XBitmap = CVS1.CreateBitmap";
_b = new anywheresoftware.b4a.objects.B4XViewWrapper.B4XBitmapWrapper();
_b = _cvs1.CreateBitmap();
 //BA.debugLineNum = 525;BA.debugLine="CVS1.Release";
_cvs1.Release();
 //BA.debugLineNum = 526;BA.debugLine="Return B";
if (true) return _b;
 //BA.debugLineNum = 527;BA.debugLine="End Sub";
return null;
}
public static anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _vvvvvvvvvvvvvvvv3() throws Exception{
ResumableSub_getGenre rsub = new ResumableSub_getGenre(null);
rsub.resume(processBA, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_getGenre extends BA.ResumableSub {
public ResumableSub_getGenre(com.kobe.code.arthur.main parent) {
this.parent = parent;
}
com.kobe.code.arthur.main parent;
String _urlgenre = "";
anywheresoftware.b4a.objects.collections.Map _response = null;
com.kobe.code.arthur.httpjob _j = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _genres = null;
anywheresoftware.b4a.objects.collections.Map _colgenres = null;
String _name = "";
int _id = 0;
anywheresoftware.b4a.BA.IterableList group14;
int index14;
int groupLen14;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
{
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
 //BA.debugLineNum = 279;BA.debugLine="Dim urlGenre As String = \"list?api_key=\"&Starter.";
_urlgenre = "list?api_key="+parent.mostCurrent._vvvvvv7._v5+"&language="+parent.mostCurrent._vvvvvv7._vv2;
 //BA.debugLineNum = 280;BA.debugLine="Dim response As Map : response.Initialize";
_response = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 280;BA.debugLine="Dim response As Map : response.Initialize";
_response.Initialize();
 //BA.debugLineNum = 282;BA.debugLine="Dim j As HttpJob";
_j = new com.kobe.code.arthur.httpjob();
 //BA.debugLineNum = 283;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize(processBA,"",main.getObject());
 //BA.debugLineNum = 284;BA.debugLine="j.Download(Starter.urlGenre&urlGenre)";
_j._vv7(parent.mostCurrent._vvvvvv7._v7+_urlgenre);
 //BA.debugLineNum = 285;BA.debugLine="j.GetRequest.Timeout = 10000";
_j._vvv6().setTimeout((int) (10000));
 //BA.debugLineNum = 286;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_j));
this.state = 11;
return;
case 11:
//C
this.state = 1;
_j = (com.kobe.code.arthur.httpjob) result[0];
;
 //BA.debugLineNum = 287;BA.debugLine="If j.Success Then";
if (true) break;

case 1:
//if
this.state = 10;
if (_j._vvvvv5) { 
this.state = 3;
}else {
this.state = 9;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 289;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 290;BA.debugLine="parser.Initialize(j.GetString)";
_parser.Initialize(_j._vvv7());
 //BA.debugLineNum = 291;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 292;BA.debugLine="Dim genres As List = root.Get(\"genres\")";
_genres = new anywheresoftware.b4a.objects.collections.List();
_genres.setObject((java.util.List)(_root.Get((Object)("genres"))));
 //BA.debugLineNum = 293;BA.debugLine="For Each colgenres As Map In genres";
if (true) break;

case 4:
//for
this.state = 7;
_colgenres = new anywheresoftware.b4a.objects.collections.Map();
group14 = _genres;
index14 = 0;
groupLen14 = group14.getSize();
this.state = 12;
if (true) break;

case 12:
//C
this.state = 7;
if (index14 < groupLen14) {
this.state = 6;
_colgenres.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group14.Get(index14)));}
if (true) break;

case 13:
//C
this.state = 12;
index14++;
if (true) break;

case 6:
//C
this.state = 13;
 //BA.debugLineNum = 294;BA.debugLine="Dim name As String = colgenres.Get(\"name\")";
_name = BA.ObjectToString(_colgenres.Get((Object)("name")));
 //BA.debugLineNum = 295;BA.debugLine="Dim id As Int = colgenres.Get(\"id\")";
_id = (int)(BA.ObjectToNumber(_colgenres.Get((Object)("id"))));
 //BA.debugLineNum = 296;BA.debugLine="response.Put(id,name)";
_response.Put((Object)(_id),(Object)(_name));
 if (true) break;
if (true) break;

case 7:
//C
this.state = 10;
;
 if (true) break;

case 9:
//C
this.state = 10;
 //BA.debugLineNum = 299;BA.debugLine="Msgbox(\"A connection error has occurred! Try aga";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("A connection error has occurred! Try again in a few minutes"),BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),mostCurrent.activityBA);
 if (true) break;

case 10:
//C
this.state = -1;
;
 //BA.debugLineNum = 302;BA.debugLine="j.Release";
_j._vvvvv3();
 //BA.debugLineNum = 304;BA.debugLine="Return response";
if (true) {
anywheresoftware.b4a.keywords.Common.ReturnFromResumableSub(this,(Object)(_response));return;};
 //BA.debugLineNum = 305;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _jobdone(com.kobe.code.arthur.httpjob _j) throws Exception{
}
public static void  _vvvvvvvvvvvvvvvv4(String _keyword) throws Exception{
ResumableSub_getMovie rsub = new ResumableSub_getMovie(null,_keyword);
rsub.resume(processBA, null);
}
public static class ResumableSub_getMovie extends BA.ResumableSub {
public ResumableSub_getMovie(com.kobe.code.arthur.main parent,String _keyword) {
this.parent = parent;
this._keyword = _keyword;
}
com.kobe.code.arthur.main parent;
String _keyword;
String _urlmovie = "";
com.kobe.code.arthur.httpjob _j = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.List _results = null;
anywheresoftware.b4a.objects.collections.Map _colresults = null;
String _title = "";
String _poster_path = "";
String _release_date = "";
int _id = 0;
anywheresoftware.b4a.BA.IterableList group18;
int index18;
int groupLen18;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 210;BA.debugLine="If keyword.Length < 1 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_keyword.length()<1) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 211;BA.debugLine="ToastMessageShow(\"Invalid keyword\",True)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Invalid keyword"),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 212;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 215;BA.debugLine="clvSearch.Clear";
parent.mostCurrent._clvsearch._vvvvvvv5();
 //BA.debugLineNum = 217;BA.debugLine="ProgressDialogShow2(\"Loading...\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 219;BA.debugLine="Dim urlMovie As String = \"?api_key=\"&Starter.apiK";
_urlmovie = "?api_key="+parent.mostCurrent._vvvvvv7._v5+"&language="+parent.mostCurrent._vvvvvv7._vv2+"&query="+_keyword;
 //BA.debugLineNum = 221;BA.debugLine="Dim j As HttpJob";
_j = new com.kobe.code.arthur.httpjob();
 //BA.debugLineNum = 222;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize(processBA,"",main.getObject());
 //BA.debugLineNum = 223;BA.debugLine="j.Download(Starter.urlSearch&urlMovie)";
_j._vv7(parent.mostCurrent._vvvvvv7._vv1+_urlmovie);
 //BA.debugLineNum = 224;BA.debugLine="j.GetRequest.Timeout = 10000";
_j._vvv6().setTimeout((int) (10000));
 //BA.debugLineNum = 225;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_j));
this.state = 15;
return;
case 15:
//C
this.state = 5;
_j = (com.kobe.code.arthur.httpjob) result[0];
;
 //BA.debugLineNum = 226;BA.debugLine="If j.Success Then";
if (true) break;

case 5:
//if
this.state = 14;
if (_j._vvvvv5) { 
this.state = 7;
}else {
this.state = 13;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 228;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 229;BA.debugLine="parser.Initialize(j.GetString)";
_parser.Initialize(_j._vvv7());
 //BA.debugLineNum = 230;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 231;BA.debugLine="Dim results As List = root.Get(\"results\")";
_results = new anywheresoftware.b4a.objects.collections.List();
_results.setObject((java.util.List)(_root.Get((Object)("results"))));
 //BA.debugLineNum = 232;BA.debugLine="For Each colresults As Map In results";
if (true) break;

case 8:
//for
this.state = 11;
_colresults = new anywheresoftware.b4a.objects.collections.Map();
group18 = _results;
index18 = 0;
groupLen18 = group18.getSize();
this.state = 16;
if (true) break;

case 16:
//C
this.state = 11;
if (index18 < groupLen18) {
this.state = 10;
_colresults.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group18.Get(index18)));}
if (true) break;

case 17:
//C
this.state = 16;
index18++;
if (true) break;

case 10:
//C
this.state = 17;
 //BA.debugLineNum = 233;BA.debugLine="Dim title As String = colresults.Get(\"title\")";
_title = BA.ObjectToString(_colresults.Get((Object)("title")));
 //BA.debugLineNum = 234;BA.debugLine="Dim poster_path As String = colresults.Get(\"pos";
_poster_path = BA.ObjectToString(_colresults.Get((Object)("poster_path")));
 //BA.debugLineNum = 235;BA.debugLine="Dim release_date As String = colresults.Get(\"re";
_release_date = BA.ObjectToString(_colresults.Get((Object)("release_date")));
 //BA.debugLineNum = 236;BA.debugLine="Dim id As Int = colresults.Get(\"id\")";
_id = (int)(BA.ObjectToNumber(_colresults.Get((Object)("id"))));
 //BA.debugLineNum = 239;BA.debugLine="clvSearch.Add(createSearchItem(id,title,release";
parent.mostCurrent._clvsearch._vvvvvvv2(_vvvvvvvvvvvvvvv0(_id,_title,_release_date,_poster_path),(Object)(_id));
 if (true) break;
if (true) break;

case 11:
//C
this.state = 14;
;
 if (true) break;

case 13:
//C
this.state = 14;
 //BA.debugLineNum = 243;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 244;BA.debugLine="Msgbox(\"A connection error has occurred! Try aga";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("A connection error has occurred! Try again in a few minutes"),BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),mostCurrent.activityBA);
 if (true) break;

case 14:
//C
this.state = -1;
;
 //BA.debugLineNum = 247;BA.debugLine="j.Release";
_j._vvvvv3();
 //BA.debugLineNum = 249;BA.debugLine="pnlSearch.SetVisibleAnimated(250, True)";
parent.mostCurrent._pnlsearch.SetVisibleAnimated((int) (250),anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 251;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 252;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _vvvvvvvvvvvvvvv4(int _page) throws Exception{
ResumableSub_getUpcoming rsub = new ResumableSub_getUpcoming(null,_page);
rsub.resume(processBA, null);
}
public static class ResumableSub_getUpcoming extends BA.ResumableSub {
public ResumableSub_getUpcoming(com.kobe.code.arthur.main parent,int _page) {
this.parent = parent;
this._page = _page;
}
com.kobe.code.arthur.main parent;
int _page;
String _urlupcoming = "";
anywheresoftware.b4a.keywords.Common.ResumableSubWrapper _rs = null;
anywheresoftware.b4a.objects.collections.Map _mapgenres = null;
com.kobe.code.arthur.httpjob _j = null;
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.Map _root = null;
anywheresoftware.b4a.objects.collections.Map _dates = null;
String _maximum = "";
String _minimum = "";
int _total_pages = 0;
anywheresoftware.b4a.objects.collections.List _results = null;
anywheresoftware.b4a.objects.collections.Map _colresults = null;
String _overview = "";
String _original_language = "";
String _original_title = "";
String _video = "";
String _title = "";
anywheresoftware.b4a.objects.collections.List _genre_ids = null;
anywheresoftware.b4a.objects.collections.List _genrelist = null;
int _colgenre_ids = 0;
String _poster_path = "";
String _backdrop_path = "";
String _release_date = "";
double _vote_average = 0;
double _popularity = 0;
int _id = 0;
String _adult = "";
int _vote_count = 0;
anywheresoftware.b4a.objects.collections.List _params = null;
int _total_results = 0;
anywheresoftware.b4a.BA.IterableList group25;
int index25;
int groupLen25;
anywheresoftware.b4a.BA.IterableList group34;
int index34;
int groupLen34;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 310;BA.debugLine="ProgressDialogShow2(\"Loading...\",False)";
anywheresoftware.b4a.keywords.Common.ProgressDialogShow2(mostCurrent.activityBA,BA.ObjectToCharSequence("Loading..."),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 312;BA.debugLine="Dim urlUpcoming As String = \"upcoming?api_key=\"&S";
_urlupcoming = "upcoming?api_key="+parent.mostCurrent._vvvvvv7._v5+"&language="+parent.mostCurrent._vvvvvv7._vv2+"&page="+BA.NumberToString(_page);
 //BA.debugLineNum = 314;BA.debugLine="Dim rs As ResumableSub";
_rs = new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper();
 //BA.debugLineNum = 315;BA.debugLine="rs = getGenre";
_rs = _vvvvvvvvvvvvvvvv3();
 //BA.debugLineNum = 316;BA.debugLine="Wait For (rs) complete (mapGenres As Map)";
anywheresoftware.b4a.keywords.Common.WaitFor("complete", processBA, this, _rs);
this.state = 29;
return;
case 29:
//C
this.state = 1;
_mapgenres = (anywheresoftware.b4a.objects.collections.Map) result[0];
;
 //BA.debugLineNum = 318;BA.debugLine="If mapGenres.Size = 0 Then";
if (true) break;

case 1:
//if
this.state = 4;
if (_mapgenres.getSize()==0) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 319;BA.debugLine="Log(\"genre error\")";
anywheresoftware.b4a.keywords.Common.Log("genre error");
 if (true) break;

case 4:
//C
this.state = 5;
;
 //BA.debugLineNum = 323;BA.debugLine="Dim j As HttpJob";
_j = new com.kobe.code.arthur.httpjob();
 //BA.debugLineNum = 324;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize(processBA,"",main.getObject());
 //BA.debugLineNum = 325;BA.debugLine="j.Download(Starter.urlPrincipal&urlUpcoming)";
_j._vv7(parent.mostCurrent._vvvvvv7._v6+_urlupcoming);
 //BA.debugLineNum = 326;BA.debugLine="j.GetRequest.Timeout = 10000";
_j._vvv6().setTimeout((int) (10000));
 //BA.debugLineNum = 327;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_j));
this.state = 30;
return;
case 30:
//C
this.state = 5;
_j = (com.kobe.code.arthur.httpjob) result[0];
;
 //BA.debugLineNum = 328;BA.debugLine="If j.Success Then";
if (true) break;

case 5:
//if
this.state = 18;
if (_j._vvvvv5) { 
this.state = 7;
}else {
this.state = 17;
}if (true) break;

case 7:
//C
this.state = 8;
 //BA.debugLineNum = 330;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
 //BA.debugLineNum = 331;BA.debugLine="parser.Initialize(j.GetString)";
_parser.Initialize(_j._vvv7());
 //BA.debugLineNum = 332;BA.debugLine="Dim root As Map = parser.NextObject";
_root = new anywheresoftware.b4a.objects.collections.Map();
_root = _parser.NextObject();
 //BA.debugLineNum = 333;BA.debugLine="Dim dates As Map = root.Get(\"dates\")";
_dates = new anywheresoftware.b4a.objects.collections.Map();
_dates.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_root.Get((Object)("dates"))));
 //BA.debugLineNum = 334;BA.debugLine="Dim maximum As String = dates.Get(\"maximum\")";
_maximum = BA.ObjectToString(_dates.Get((Object)("maximum")));
 //BA.debugLineNum = 335;BA.debugLine="Dim minimum As String = dates.Get(\"minimum\")";
_minimum = BA.ObjectToString(_dates.Get((Object)("minimum")));
 //BA.debugLineNum = 336;BA.debugLine="Dim page As Int = root.Get(\"page\")";
_page = (int)(BA.ObjectToNumber(_root.Get((Object)("page"))));
 //BA.debugLineNum = 337;BA.debugLine="Dim total_pages As Int = root.Get(\"total_pages\")";
_total_pages = (int)(BA.ObjectToNumber(_root.Get((Object)("total_pages"))));
 //BA.debugLineNum = 339;BA.debugLine="totalPages = total_pages";
parent._vvvvvvvvvvvvvvv3 = _total_pages;
 //BA.debugLineNum = 340;BA.debugLine="Dim results As List = root.Get(\"results\")";
_results = new anywheresoftware.b4a.objects.collections.List();
_results.setObject((java.util.List)(_root.Get((Object)("results"))));
 //BA.debugLineNum = 341;BA.debugLine="For Each colresults As Map In results";
if (true) break;

case 8:
//for
this.state = 15;
_colresults = new anywheresoftware.b4a.objects.collections.Map();
group25 = _results;
index25 = 0;
groupLen25 = group25.getSize();
this.state = 31;
if (true) break;

case 31:
//C
this.state = 15;
if (index25 < groupLen25) {
this.state = 10;
_colresults.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(group25.Get(index25)));}
if (true) break;

case 32:
//C
this.state = 31;
index25++;
if (true) break;

case 10:
//C
this.state = 11;
 //BA.debugLineNum = 342;BA.debugLine="Dim overview As String = colresults.Get(\"overvi";
_overview = BA.ObjectToString(_colresults.Get((Object)("overview")));
 //BA.debugLineNum = 343;BA.debugLine="Dim original_language As String = colresults.Ge";
_original_language = BA.ObjectToString(_colresults.Get((Object)("original_language")));
 //BA.debugLineNum = 344;BA.debugLine="Dim original_title As String = colresults.Get(\"";
_original_title = BA.ObjectToString(_colresults.Get((Object)("original_title")));
 //BA.debugLineNum = 345;BA.debugLine="Dim video As String = colresults.Get(\"video\")";
_video = BA.ObjectToString(_colresults.Get((Object)("video")));
 //BA.debugLineNum = 346;BA.debugLine="Dim title As String = colresults.Get(\"title\") '";
_title = BA.ObjectToString(_colresults.Get((Object)("title")));
 //BA.debugLineNum = 347;BA.debugLine="Dim genre_ids As List = colresults.Get(\"genre_i";
_genre_ids = new anywheresoftware.b4a.objects.collections.List();
_genre_ids.setObject((java.util.List)(_colresults.Get((Object)("genre_ids"))));
 //BA.debugLineNum = 349;BA.debugLine="Dim genreList As List : genreList.initialize";
_genrelist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 349;BA.debugLine="Dim genreList As List : genreList.initialize";
_genrelist.Initialize();
 //BA.debugLineNum = 350;BA.debugLine="For Each colgenre_ids As Int In genre_ids";
if (true) break;

case 11:
//for
this.state = 14;
group34 = _genre_ids;
index34 = 0;
groupLen34 = group34.getSize();
this.state = 33;
if (true) break;

case 33:
//C
this.state = 14;
if (index34 < groupLen34) {
this.state = 13;
_colgenre_ids = (int)(BA.ObjectToNumber(group34.Get(index34)));}
if (true) break;

case 34:
//C
this.state = 33;
index34++;
if (true) break;

case 13:
//C
this.state = 34;
 //BA.debugLineNum = 351;BA.debugLine="genreList.Add(mapGenres.Get(colgenre_ids))";
_genrelist.Add(_mapgenres.Get((Object)(_colgenre_ids)));
 if (true) break;
if (true) break;

case 14:
//C
this.state = 32;
;
 //BA.debugLineNum = 354;BA.debugLine="Dim poster_path As String = colresults.Get(\"pos";
_poster_path = BA.ObjectToString(_colresults.Get((Object)("poster_path")));
 //BA.debugLineNum = 355;BA.debugLine="Dim backdrop_path As String = colresults.Get(\"b";
_backdrop_path = BA.ObjectToString(_colresults.Get((Object)("backdrop_path")));
 //BA.debugLineNum = 356;BA.debugLine="Dim release_date As String = colresults.Get(\"re";
_release_date = BA.ObjectToString(_colresults.Get((Object)("release_date")));
 //BA.debugLineNum = 357;BA.debugLine="Dim vote_average As Double = colresults.Get(\"vo";
_vote_average = (double)(BA.ObjectToNumber(_colresults.Get((Object)("vote_average"))));
 //BA.debugLineNum = 358;BA.debugLine="Dim popularity As Double = colresults.Get(\"popu";
_popularity = (double)(BA.ObjectToNumber(_colresults.Get((Object)("popularity"))));
 //BA.debugLineNum = 359;BA.debugLine="Dim id As Int = colresults.Get(\"id\")";
_id = (int)(BA.ObjectToNumber(_colresults.Get((Object)("id"))));
 //BA.debugLineNum = 360;BA.debugLine="Dim adult As String = colresults.Get(\"adult\")";
_adult = BA.ObjectToString(_colresults.Get((Object)("adult")));
 //BA.debugLineNum = 361;BA.debugLine="Dim vote_count As Int = colresults.Get(\"vote_co";
_vote_count = (int)(BA.ObjectToNumber(_colresults.Get((Object)("vote_count"))));
 //BA.debugLineNum = 363;BA.debugLine="clvUpcoming.Add(createUpcomingItem(id,title,rel";
parent.mostCurrent._clvupcoming._vvvvvvv2(_vvvvvvvvvvvvvvvv1(_id,_title,_release_date,_poster_path,_genrelist),(Object)(_id));
 //BA.debugLineNum = 365;BA.debugLine="mapAuxGenres.Put(id,lblUpcomingClvGenre.Text) '";
parent.mostCurrent._vvvvvvvvvvvvvvv7.Put((Object)(_id),(Object)(parent.mostCurrent._lblupcomingclvgenre.getText()));
 //BA.debugLineNum = 367;BA.debugLine="Dim params As List : params.initialize";
_params = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 367;BA.debugLine="Dim params As List : params.initialize";
_params.Initialize();
 //BA.debugLineNum = 368;BA.debugLine="params.AddAll(Array As String(title,release_dat";
_params.AddAll(anywheresoftware.b4a.keywords.Common.ArrayToList(new String[]{_title,_release_date,_poster_path,_overview}));
 //BA.debugLineNum = 369;BA.debugLine="mapAuxMovieInfo.Put(id,params)";
parent.mostCurrent._vvvvvvvvvvvvvvv6.Put((Object)(_id),(Object)(_params.getObject()));
 if (true) break;
if (true) break;

case 15:
//C
this.state = 18;
;
 //BA.debugLineNum = 372;BA.debugLine="Dim total_results As Int = root.Get(\"total_resul";
_total_results = (int)(BA.ObjectToNumber(_root.Get((Object)("total_results"))));
 if (true) break;

case 17:
//C
this.state = 18;
 //BA.debugLineNum = 375;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 376;BA.debugLine="Msgbox(\"A connection error has occurred! Try aga";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("A connection error has occurred! Try again in a few minutes"),BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),mostCurrent.activityBA);
 if (true) break;

case 18:
//C
this.state = 19;
;
 //BA.debugLineNum = 379;BA.debugLine="j.Release";
_j._vvvvv3();
 //BA.debugLineNum = 381;BA.debugLine="Sleep(700)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (700));
this.state = 35;
return;
case 35:
//C
this.state = 19;
;
 //BA.debugLineNum = 383;BA.debugLine="Try";
if (true) break;

case 19:
//try
this.state = 28;
this.catchState = 27;
this.state = 21;
if (true) break;

case 21:
//C
this.state = 22;
this.catchState = 27;
 //BA.debugLineNum = 384;BA.debugLine="If lastPage > 1 Then";
if (true) break;

case 22:
//if
this.state = 25;
if (parent._vvvvvvvvvvvvvvv2>1) { 
this.state = 24;
}if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 385;BA.debugLine="clvUpcoming.JumpToItem(20 * (lastPage - 1))";
parent.mostCurrent._clvupcoming._vvvvvvvvvv3((int) (20*(parent._vvvvvvvvvvvvvvv2-1)));
 if (true) break;

case 25:
//C
this.state = 28;
;
 if (true) break;

case 27:
//C
this.state = 28;
this.catchState = 0;
 //BA.debugLineNum = 388;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage());
 if (true) break;
if (true) break;

case 28:
//C
this.state = -1;
this.catchState = 0;
;
 //BA.debugLineNum = 393;BA.debugLine="ProgressDialogHide";
anywheresoftware.b4a.keywords.Common.ProgressDialogHide();
 //BA.debugLineNum = 394;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _complete(anywheresoftware.b4a.objects.collections.Map _mapgenres) throws Exception{
}
public static String  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 28;BA.debugLine="Private ToolBar As ACToolBarLight";
mostCurrent._toolbar = new de.amberhome.objects.appcompat.ACToolbarLightWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Dim sv As ACSearchView";
mostCurrent._vvvvvvvvvvvv5 = new de.amberhome.objects.appcompat.ACSearchViewWrapper();
 //BA.debugLineNum = 30;BA.debugLine="Dim itemsearch As ACMenuItem";
mostCurrent._vvvvvvvvvvvvvv7 = new de.amberhome.objects.appcompat.ACMenuItemWrapper();
 //BA.debugLineNum = 33;BA.debugLine="Private pnlMain As Panel";
mostCurrent._pnlmain = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 34;BA.debugLine="Private clvUpcoming As CustomListView";
mostCurrent._clvupcoming = new com.kobe.code.arthur.customlistview();
 //BA.debugLineNum = 35;BA.debugLine="Private imgUpcomingClvPoster As ImageView";
mostCurrent._imgupcomingclvposter = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 36;BA.debugLine="Private lblUpcomingClvName As Label";
mostCurrent._lblupcomingclvname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 37;BA.debugLine="Private lblUpcomingClvRelease As Label";
mostCurrent._lblupcomingclvrelease = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 38;BA.debugLine="Private lblUpcomingClvGenre As Label";
mostCurrent._lblupcomingclvgenre = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 41;BA.debugLine="Private pnlDetails As Panel";
mostCurrent._pnldetails = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 42;BA.debugLine="Private imgDetailsMovie As ImageView";
mostCurrent._imgdetailsmovie = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 43;BA.debugLine="Private lblDetailsName As Label";
mostCurrent._lbldetailsname = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 44;BA.debugLine="Private lblDetailRelease As Label";
mostCurrent._lbldetailrelease = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 45;BA.debugLine="Private lblDetailsGenre As Label";
mostCurrent._lbldetailsgenre = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 46;BA.debugLine="Private clvDetailsOverview As CustomListView";
mostCurrent._clvdetailsoverview = new com.kobe.code.arthur.customlistview();
 //BA.debugLineNum = 49;BA.debugLine="Private lastReachEndTime As Long";
_vvvvvvvvvvvvvvv1 = 0L;
 //BA.debugLineNum = 50;BA.debugLine="Private lastPage As Int";
_vvvvvvvvvvvvvvv2 = 0;
 //BA.debugLineNum = 51;BA.debugLine="Private totalPages As Int";
_vvvvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 52;BA.debugLine="Private mapAuxGenres As Map";
mostCurrent._vvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 53;BA.debugLine="Private mapAuxMovieInfo As Map";
mostCurrent._vvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 56;BA.debugLine="Private imgBackgroundIntro As Panel";
mostCurrent._vvvvvvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 57;BA.debugLine="Private imgLogo1Intro As ImageView";
mostCurrent._vvvvvvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.ImageViewWrapper();
 //BA.debugLineNum = 60;BA.debugLine="Private pnlSearch As Panel";
mostCurrent._pnlsearch = new anywheresoftware.b4a.objects.PanelWrapper();
 //BA.debugLineNum = 61;BA.debugLine="Private clvSearch As CustomListView";
mostCurrent._clvsearch = new com.kobe.code.arthur.customlistview();
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _imgbackgroundintro_click() throws Exception{
 //BA.debugLineNum = 502;BA.debugLine="Sub imgBackgroundIntro_Click";
 //BA.debugLineNum = 504;BA.debugLine="End Sub";
return "";
}
public static void  _load_app() throws Exception{
ResumableSub_Load_App rsub = new ResumableSub_Load_App(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Load_App extends BA.ResumableSub {
public ResumableSub_Load_App(com.kobe.code.arthur.main parent) {
this.parent = parent;
}
com.kobe.code.arthur.main parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 170;BA.debugLine="mapAuxGenres.Initialize";
parent.mostCurrent._vvvvvvvvvvvvvvv7.Initialize();
 //BA.debugLineNum = 171;BA.debugLine="mapAuxMovieInfo.Initialize";
parent.mostCurrent._vvvvvvvvvvvvvvv6.Initialize();
 //BA.debugLineNum = 173;BA.debugLine="lastPage = 1";
parent._vvvvvvvvvvvvvvv2 = (int) (1);
 //BA.debugLineNum = 174;BA.debugLine="getUpcoming(lastPage)";
_vvvvvvvvvvvvvvv4(parent._vvvvvvvvvvvvvvv2);
 //BA.debugLineNum = 176;BA.debugLine="Sleep(3000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (3000));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 178;BA.debugLine="Remove_Splash";
_remove_splash();
 //BA.debugLineNum = 179;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static void  _load_intro() throws Exception{
ResumableSub_Load_Intro rsub = new ResumableSub_Load_Intro(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Load_Intro extends BA.ResumableSub {
public ResumableSub_Load_Intro(com.kobe.code.arthur.main parent) {
this.parent = parent;
}
com.kobe.code.arthur.main parent;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = -1;
 //BA.debugLineNum = 138;BA.debugLine="SetStatusBarColor(Colors.Black)";
_vvvvvvvvvvvvvvvv7(anywheresoftware.b4a.keywords.Common.Colors.Black);
 //BA.debugLineNum = 140;BA.debugLine="imgBackgroundIntro.Initialize(\"imgBackgroundIntro";
parent.mostCurrent._vvvvvvvvvvvvvvvv5.Initialize(mostCurrent.activityBA,"imgBackgroundIntro");
 //BA.debugLineNum = 141;BA.debugLine="Activity.AddView(imgBackgroundIntro,0%x,0%y,100%x";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvv5.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (0),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (100),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (100),mostCurrent.activityBA));
 //BA.debugLineNum = 142;BA.debugLine="imgBackgroundIntro.Color = 0xFFFFFFFF";
parent.mostCurrent._vvvvvvvvvvvvvvvv5.setColor((int) (0xffffffff));
 //BA.debugLineNum = 143;BA.debugLine="imgBackgroundIntro.BringToFront";
parent.mostCurrent._vvvvvvvvvvvvvvvv5.BringToFront();
 //BA.debugLineNum = 144;BA.debugLine="SetElevation(imgBackgroundIntro,10dip)";
_vvvvvvvvvvvvvvvv0((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvv5.getObject())),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (10))));
 //BA.debugLineNum = 147;BA.debugLine="imgLogo1Intro.Initialize(\"imgLogo1Intro\")";
parent.mostCurrent._vvvvvvvvvvvvvvvv6.Initialize(mostCurrent.activityBA,"imgLogo1Intro");
 //BA.debugLineNum = 148;BA.debugLine="imgLogo1Intro.Visible = False";
parent.mostCurrent._vvvvvvvvvvvvvvvv6.setVisible(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 149;BA.debugLine="Activity.AddView(imgLogo1Intro,30%x,30%y,40%x,40%";
parent.mostCurrent._activity.AddView((android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvv6.getObject()),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (30),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerXToCurrent((float) (40),mostCurrent.activityBA),anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (40),mostCurrent.activityBA));
 //BA.debugLineNum = 150;BA.debugLine="imgLogo1Intro.Bitmap = LoadBitmapResize(File.DirA";
parent.mostCurrent._vvvvvvvvvvvvvvvv6.setBitmap((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"appIcon.png",parent.mostCurrent._vvvvvvvvvvvvvvvv6.getWidth(),parent.mostCurrent._vvvvvvvvvvvvvvvv6.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject()));
 //BA.debugLineNum = 151;BA.debugLine="imgLogo1Intro.Visible = True";
parent.mostCurrent._vvvvvvvvvvvvvvvv6.setVisible(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 152;BA.debugLine="imgLogo1Intro.BringToFront";
parent.mostCurrent._vvvvvvvvvvvvvvvv6.BringToFront();
 //BA.debugLineNum = 153;BA.debugLine="SetElevation(imgLogo1Intro,11dip)";
_vvvvvvvvvvvvvvvv0((anywheresoftware.b4a.objects.ConcreteViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.ConcreteViewWrapper(), (android.view.View)(parent.mostCurrent._vvvvvvvvvvvvvvvv6.getObject())),(float) (anywheresoftware.b4a.keywords.Common.DipToCurrent((int) (11))));
 //BA.debugLineNum = 155;BA.debugLine="Sleep(1000)";
anywheresoftware.b4a.keywords.Common.Sleep(mostCurrent.activityBA,this,(int) (1000));
this.state = 1;
return;
case 1:
//C
this.state = -1;
;
 //BA.debugLineNum = 158;BA.debugLine="Load_App";
_load_app();
 //BA.debugLineNum = 159;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public static String  _pnldetails_click() throws Exception{
 //BA.debugLineNum = 498;BA.debugLine="Sub pnlDetails_Click";
 //BA.debugLineNum = 500;BA.debugLine="End Sub";
return "";
}
public static String  _pnlmain_click() throws Exception{
 //BA.debugLineNum = 494;BA.debugLine="Sub pnlMain_Click";
 //BA.debugLineNum = 496;BA.debugLine="End Sub";
return "";
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
starter._process_globals();
httputils2service._process_globals();
getimage._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 21;BA.debugLine="Private xui As XUI";
_vvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public static String  _remove_splash() throws Exception{
 //BA.debugLineNum = 162;BA.debugLine="Sub Remove_Splash";
 //BA.debugLineNum = 164;BA.debugLine="If imgBackgroundIntro.IsInitialized Then imgBackg";
if (mostCurrent._vvvvvvvvvvvvvvvv5.IsInitialized()) { 
mostCurrent._vvvvvvvvvvvvvvvv5.RemoveView();};
 //BA.debugLineNum = 165;BA.debugLine="If imgLogo1Intro.IsInitialized Then imgLogo1Intro";
if (mostCurrent._vvvvvvvvvvvvvvvv6.IsInitialized()) { 
mostCurrent._vvvvvvvvvvvvvvvv6.RemoveView();};
 //BA.debugLineNum = 166;BA.debugLine="End Sub";
return "";
}
public static String  _search_querysubmitted(String _query) throws Exception{
 //BA.debugLineNum = 201;BA.debugLine="Sub Search_QuerySubmitted (Query As String)";
 //BA.debugLineNum = 202;BA.debugLine="sv.Iconfied = True";
mostCurrent._vvvvvvvvvvvv5.setIconfied(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 203;BA.debugLine="itemsearch.ItemCollapsed = True";
mostCurrent._vvvvvvvvvvvvvv7.setItemCollapsed(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 204;BA.debugLine="searchnow(Query)";
_vvvvvvvvvvvvvvvvv1(_query);
 //BA.debugLineNum = 205;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvvv1(String _keyword) throws Exception{
 //BA.debugLineNum = 195;BA.debugLine="Sub searchnow(keyword As String)";
 //BA.debugLineNum = 196;BA.debugLine="Log(\"Search function with keyword is :\" & keyword";
anywheresoftware.b4a.keywords.Common.Log("Search function with keyword is :"+_keyword);
 //BA.debugLineNum = 197;BA.debugLine="getMovie(keyword)";
_vvvvvvvvvvvvvvvv4(_keyword);
 //BA.debugLineNum = 198;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvv0(anywheresoftware.b4a.objects.ConcreteViewWrapper _v,float _e) throws Exception{
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4a.phone.Phone _p = null;
 //BA.debugLineNum = 543;BA.debugLine="Sub SetElevation(v As View, e As Float)";
 //BA.debugLineNum = 544;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 545;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 547;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 548;BA.debugLine="jo = v";
_jo.setObject((java.lang.Object)(_v.getObject()));
 //BA.debugLineNum = 549;BA.debugLine="jo.RunMethod(\"setElevation\", Array As Object(e))";
_jo.RunMethod("setElevation",new Object[]{(Object)(_e)});
 };
 //BA.debugLineNum = 551;BA.debugLine="End Sub";
return "";
}
public static String  _vvvvvvvvvvvvvvvv7(int _clr) throws Exception{
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _jo = null;
anywheresoftware.b4j.object.JavaObject _window = null;
 //BA.debugLineNum = 530;BA.debugLine="Sub SetStatusBarColor(clr As Int)";
 //BA.debugLineNum = 531;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
 //BA.debugLineNum = 532;BA.debugLine="If p.SdkVersion >= 21 Then";
if (_p.getSdkVersion()>=21) { 
 //BA.debugLineNum = 533;BA.debugLine="Dim jo As JavaObject";
_jo = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 534;BA.debugLine="jo.InitializeContext";
_jo.InitializeContext(processBA);
 //BA.debugLineNum = 535;BA.debugLine="Dim window As JavaObject = jo.RunMethodJO(\"getWi";
_window = new anywheresoftware.b4j.object.JavaObject();
_window = _jo.RunMethodJO("getWindow",(Object[])(anywheresoftware.b4a.keywords.Common.Null));
 //BA.debugLineNum = 536;BA.debugLine="window.RunMethod(\"addFlags\", Array (0x80000000))";
_window.RunMethod("addFlags",new Object[]{(Object)(0x80000000)});
 //BA.debugLineNum = 537;BA.debugLine="window.RunMethod(\"clearFlags\", Array (0x04000000";
_window.RunMethod("clearFlags",new Object[]{(Object)(0x04000000)});
 //BA.debugLineNum = 538;BA.debugLine="window.RunMethod(\"setStatusBarColor\", Array(clr)";
_window.RunMethod("setStatusBarColor",new Object[]{(Object)(_clr)});
 };
 //BA.debugLineNum = 540;BA.debugLine="End Sub";
return "";
}
public boolean _onCreateOptionsMenu(android.view.Menu menu) {
    if (processBA.subExists("activity_createmenu")) {
        processBA.raiseEvent2(null, true, "activity_createmenu", false, new de.amberhome.objects.appcompat.ACMenuWrapper(menu));
        return true;
    }
    else
        return false;
}
}
