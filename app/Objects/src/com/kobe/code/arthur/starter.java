package com.kobe.code.arthur;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (starter) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, true, BA.class);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.kobe.code.arthur", "com.kobe.code.arthur.starter");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "com.kobe.code.arthur.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (starter) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = ServiceHelper.StarterHelper.handleStartIntent(intent, _service, processBA);
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        if (true) {
            BA.LogInfo("** Service (starter) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (starter) Destroy **");
		    processBA.raiseEvent(null, "service_destroy");
            processBA.service = null;
		    mostCurrent = null;
		    processBA.setActivityPaused(true);
            processBA.runHook("ondestroy", this, null);
        }
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static String _v5 = "";
public static String _v6 = "";
public static String _v7 = "";
public static String _v0 = "";
public static String _vv1 = "";
public static String _vv2 = "";
public static anywheresoftware.b4a.objects.StringUtils _vv3 = null;
public com.kobe.code.arthur.main _vvvvvv6 = null;
public com.kobe.code.arthur.httputils2service _vvvvvv0 = null;
public com.kobe.code.arthur.getimage _vvvvvvv1 = null;
public static boolean  _application_error(anywheresoftware.b4a.objects.B4AException _error,String _stacktrace) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Sub Application_Error (Error As Exception, StackTr";
 //BA.debugLineNum = 38;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return false;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="Public apiKey As String = \"c5850ed73901b8d268d089";
_v5 = BA.__b (new byte[] {48,116,73,-83,116,58,27,-5,44,107,93,-30,55,56,25,-10,109,96,12,-21,106,103,87,-8,99,32,71,-73,57,49,20,-85}, 531696);
 //BA.debugLineNum = 11;BA.debugLine="Public urlPrincipal As String = \"https://api.them";
_v6 = BA.__b (new byte[] {59,52,14,-6,55,100,91,-15,126,35,15,-17,33,105,19,-69,52,47,10,-84,54,61,74,-28,41,39,90,-14,46,63,22,-87,61,123,71}, 60498);
 //BA.debugLineNum = 12;BA.debugLine="Public urlGenre As String = \"https://api.themovie";
_v7 = BA.__b (new byte[] {59,53,0,-90,55,101,85,-83,126,34,1,-77,33,104,29,-25,52,46,4,-16,54,60,68,-72,41,38,84,-82,46,52,18,-19,38,122,73,-26,43,48,5,-17,99}, 523197);
 //BA.debugLineNum = 13;BA.debugLine="Public urlPoster As String = \"https://image.tmdb.";
_v0 = BA.__b (new byte[] {59,53,126,32,55,101,43,43,118,63,119,124,48,46,114,97,63,58,61,124,32,57,59,37,116,49,42,108,48,107,60}, 604773);
 //BA.debugLineNum = 14;BA.debugLine="Public urlSearch As String = \"https://api.themovi";
_vv1 = BA.__b (new byte[] {59,52,4,43,55,100,81,32,126,35,5,62,33,105,25,106,52,47,0,125,54,61,64,53,41,39,80,35,46,33,22,111,38,125,10,41,41,40,30,110,41}, 70696);
 //BA.debugLineNum = 15;BA.debugLine="Public language As String = \"en-US\"";
_vv2 = BA.__b (new byte[] {54,47,-124,113,23}, 889561);
 //BA.debugLineNum = 17;BA.debugLine="Public su As StringUtils";
_vv3 = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 41;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 43;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 27;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public static String  _service_taskremoved() throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Sub Service_TaskRemoved";
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
}
