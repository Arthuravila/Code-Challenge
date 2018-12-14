package com.kobe.code.arthur;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class httputils2service extends  android.app.Service{
	public static class httputils2service_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (httputils2service) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, httputils2service.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, BA.class);
		}

	}
    static httputils2service mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return httputils2service.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.kobe.code.arthur", "com.kobe.code.arthur.httputils2service");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "com.kobe.code.arthur.httputils2service", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (httputils2service) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
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
                    BA.LogInfo("** Service (httputils2service) Create **");
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
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (httputils2service) Start **");
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
        if (false) {
            BA.LogInfo("** Service (httputils2service) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (httputils2service) Destroy **");
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
public static anywheresoftware.b4h.okhttp.OkHttpClientWrapper _vvvvvvvvvvvvvvvvv4 = null;
public static anywheresoftware.b4a.objects.collections.Map _vvvvvvvvvvvvvvvvv3 = null;
public static String _vv4 = "";
public static int _vvvvvvvvvvvvvvvvv5 = 0;
public com.kobe.code.arthur.main _vvvvvv6 = null;
public com.kobe.code.arthur.starter _vvvvvv7 = null;
public com.kobe.code.arthur.getimage _vvvvvvv1 = null;
public static String  _vvvvvvvvvvvvvvvvv2(int _taskid,boolean _success,String _errormessage) throws Exception{
com.kobe.code.arthur.httpjob _job = null;
 //BA.debugLineNum = 104;BA.debugLine="Sub CompleteJob(TaskId As Int, success As Boolean,";
 //BA.debugLineNum = 108;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (com.kobe.code.arthur.httpjob)(_vvvvvvvvvvvvvvvvv3.Get((Object)(_taskid)));
 //BA.debugLineNum = 109;BA.debugLine="TaskIdToJob.Remove(TaskId)";
_vvvvvvvvvvvvvvvvv3.Remove((Object)(_taskid));
 //BA.debugLineNum = 110;BA.debugLine="job.success = success";
_job._vvvvv5 = _success;
 //BA.debugLineNum = 111;BA.debugLine="job.errorMessage = errorMessage";
_job._vvvvv0 = _errormessage;
 //BA.debugLineNum = 113;BA.debugLine="job.Complete(TaskId)";
_job._complete(_taskid);
 //BA.debugLineNum = 117;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responseerror(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,String _reason,int _statuscode,int _taskid) throws Exception{
com.kobe.code.arthur.httpjob _job = null;
 //BA.debugLineNum = 81;BA.debugLine="Sub hc_ResponseError (Response As OkHttpResponse,";
 //BA.debugLineNum = 82;BA.debugLine="Log($\"ResponseError. Reason: ${Reason}, Response:";
anywheresoftware.b4a.keywords.Common.Log(("ResponseError. Reason: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_reason))+", Response: "+anywheresoftware.b4a.keywords.Common.SmartStringFormatter("",(Object)(_response.getErrorResponse()))+""));
 //BA.debugLineNum = 83;BA.debugLine="Response.Release";
_response.Release();
 //BA.debugLineNum = 84;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (com.kobe.code.arthur.httpjob)(_vvvvvvvvvvvvvvvvv3.Get((Object)(_taskid)));
 //BA.debugLineNum = 85;BA.debugLine="job.Response = Response";
_job._vvvvvv4 = _response;
 //BA.debugLineNum = 86;BA.debugLine="If Response.ErrorResponse <> \"\" Then";
if ((_response.getErrorResponse()).equals("") == false) { 
 //BA.debugLineNum = 87;BA.debugLine="CompleteJob(TaskId, False, Response.ErrorRespons";
_vvvvvvvvvvvvvvvvv2(_taskid,anywheresoftware.b4a.keywords.Common.False,_response.getErrorResponse());
 }else {
 //BA.debugLineNum = 89;BA.debugLine="CompleteJob(TaskId, False, Reason)";
_vvvvvvvvvvvvvvvvv2(_taskid,anywheresoftware.b4a.keywords.Common.False,_reason);
 };
 //BA.debugLineNum = 91;BA.debugLine="End Sub";
return "";
}
public static String  _hc_responsesuccess(anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _response,int _taskid) throws Exception{
com.kobe.code.arthur.httpjob _job = null;
 //BA.debugLineNum = 63;BA.debugLine="Sub hc_ResponseSuccess (Response As OkHttpResponse";
 //BA.debugLineNum = 64;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
_job = (com.kobe.code.arthur.httpjob)(_vvvvvvvvvvvvvvvvv3.Get((Object)(_taskid)));
 //BA.debugLineNum = 65;BA.debugLine="job.Tag = Response.GetHeaders";
_job._vvvvvv5 = (Object)(_response.GetHeaders().getObject());
 //BA.debugLineNum = 67;BA.debugLine="Response.GetAsynchronously(\"response\", File.Ope";
_response.GetAsynchronously(processBA,"response",(java.io.OutputStream)(anywheresoftware.b4a.keywords.Common.File.OpenOutput(_vv4,BA.NumberToString(_taskid),anywheresoftware.b4a.keywords.Common.False).getObject()),anywheresoftware.b4a.keywords.Common.True,_taskid);
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Private hc As OkHttpClient";
_vvvvvvvvvvvvvvvvv4 = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private TaskIdToJob As Map";
_vvvvvvvvvvvvvvvvv3 = new anywheresoftware.b4a.objects.collections.Map();
 //BA.debugLineNum = 11;BA.debugLine="Public TempFolder As String";
_vv4 = "";
 //BA.debugLineNum = 12;BA.debugLine="Private taskCounter As Int";
_vvvvvvvvvvvvvvvvv5 = 0;
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public static String  _response_streamfinish(boolean _success,int _taskid) throws Exception{
 //BA.debugLineNum = 73;BA.debugLine="Sub Response_StreamFinish (Success As Boolean, Tas";
 //BA.debugLineNum = 74;BA.debugLine="If Success Then";
if (_success) { 
 //BA.debugLineNum = 75;BA.debugLine="CompleteJob(TaskId, Success, \"\")";
_vvvvvvvvvvvvvvvvv2(_taskid,_success,"");
 }else {
 //BA.debugLineNum = 77;BA.debugLine="CompleteJob(TaskId, Success, LastException.Messa";
_vvvvvvvvvvvvvvvvv2(_taskid,_success,anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 79;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 18;BA.debugLine="TempFolder = File.DirInternalCache";
_vv4 = anywheresoftware.b4a.keywords.Common.File.getDirInternalCache();
 //BA.debugLineNum = 19;BA.debugLine="Try";
try { //BA.debugLineNum = 20;BA.debugLine="File.WriteString(TempFolder, \"~test.test\", \"test";
anywheresoftware.b4a.keywords.Common.File.WriteString(_vv4,"~test.test","test");
 //BA.debugLineNum = 21;BA.debugLine="File.Delete(TempFolder, \"~test.test\")";
anywheresoftware.b4a.keywords.Common.File.Delete(_vv4,"~test.test");
 } 
       catch (Exception e6) {
			processBA.setLastException(e6); //BA.debugLineNum = 23;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.Log(BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(processBA)));
 //BA.debugLineNum = 24;BA.debugLine="Log(\"Switching to File.DirInternal\")";
anywheresoftware.b4a.keywords.Common.Log("Switching to File.DirInternal");
 //BA.debugLineNum = 25;BA.debugLine="TempFolder = File.DirInternal";
_vv4 = anywheresoftware.b4a.keywords.Common.File.getDirInternal();
 };
 //BA.debugLineNum = 31;BA.debugLine="hc.InitializeAcceptAll(\"hc\")";
_vvvvvvvvvvvvvvvvv4.InitializeAcceptAll("hc");
 //BA.debugLineNum = 32;BA.debugLine="TaskIdToJob.Initialize";
_vvvvvvvvvvvvvvvvv3.Initialize();
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 38;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 35;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 36;BA.debugLine="End Sub";
return "";
}
public static String  _submitjob(com.kobe.code.arthur.httpjob _job) throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Public Sub SubmitJob(job As HttpJob)";
 //BA.debugLineNum = 44;BA.debugLine="If hc.IsInitialized = False Then Service_Create";
if (_vvvvvvvvvvvvvvvvv4.IsInitialized()==anywheresoftware.b4a.keywords.Common.False) { 
_service_create();};
 //BA.debugLineNum = 45;BA.debugLine="taskCounter = taskCounter + 1";
_vvvvvvvvvvvvvvvvv5 = (int) (_vvvvvvvvvvvvvvvvv5+1);
 //BA.debugLineNum = 46;BA.debugLine="TaskIdToJob.Put(taskCounter, job)";
_vvvvvvvvvvvvvvvvv3.Put((Object)(_vvvvvvvvvvvvvvvvv5),(Object)(_job));
 //BA.debugLineNum = 47;BA.debugLine="If job.Username <> \"\" And job.Password <> \"\" Then";
if ((_job._vvvvv6).equals("") == false && (_job._vvvvv7).equals("") == false) { 
 //BA.debugLineNum = 48;BA.debugLine="hc.ExecuteCredentials(job.GetRequest, taskCounte";
_vvvvvvvvvvvvvvvvv4.ExecuteCredentials(processBA,_job._vvv6(),_vvvvvvvvvvvvvvvvv5,_job._vvvvv6,_job._vvvvv7);
 }else {
 //BA.debugLineNum = 50;BA.debugLine="hc.Execute(job.GetRequest, taskCounter)";
_vvvvvvvvvvvvvvvvv4.Execute(processBA,_job._vvv6(),_vvvvvvvvvvvvvvvvv5);
 };
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
}
