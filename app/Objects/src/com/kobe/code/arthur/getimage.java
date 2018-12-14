package com.kobe.code.arthur;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class getimage extends  android.app.Service{
	public static class getimage_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
            BA.LogInfo("** Receiver (getimage) OnReceive **");
			android.content.Intent in = new android.content.Intent(context, getimage.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
            ServiceHelper.StarterHelper.startServiceFromReceiver (context, in, false, BA.class);
		}

	}
    static getimage mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return getimage.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "com.kobe.code.arthur", "com.kobe.code.arthur.getimage");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "com.kobe.code.arthur.getimage", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (getimage) Create ***");
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
                    BA.LogInfo("** Service (getimage) Create **");
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
    	BA.LogInfo("** Service (getimage) Start **");
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
            BA.LogInfo("** Service (getimage) Destroy (ignored)**");
        }
        else {
            BA.LogInfo("** Service (getimage) Destroy **");
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
public static boolean _vvvvvvvvvvvvvvvvv6 = false;
public static anywheresoftware.b4a.objects.RuntimePermissions _vvvvvvvvvvvvvvvvv7 = null;
public com.kobe.code.arthur.main _vvvvvv6 = null;
public com.kobe.code.arthur.starter _vvvvvv7 = null;
public com.kobe.code.arthur.httputils2service _vvvvvv0 = null;
public static void  _baixa_imagem(anywheresoftware.b4a.objects.ImageViewWrapper _iv,String _url) throws Exception{
ResumableSub_Baixa_Imagem rsub = new ResumableSub_Baixa_Imagem(null,_iv,_url);
rsub.resume(processBA, null);
}
public static class ResumableSub_Baixa_Imagem extends BA.ResumableSub {
public ResumableSub_Baixa_Imagem(com.kobe.code.arthur.getimage parent,anywheresoftware.b4a.objects.ImageViewWrapper _iv,String _url) {
this.parent = parent;
this._iv = _iv;
this._url = _url;
}
com.kobe.code.arthur.getimage parent;
anywheresoftware.b4a.objects.ImageViewWrapper _iv;
String _url;
com.kobe.code.arthur.httpjob _j = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;

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
 //BA.debugLineNum = 21;BA.debugLine="If cacheAtivado Then 'SE O CACHE ESTIVER ATIVADO";
if (true) break;

case 1:
//if
this.state = 8;
if (parent._vvvvvvvvvvvvvvvvv6) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 22;BA.debugLine="If File.Exists(rp.GetSafeDirDefaultExternal(\"cac";
if (true) break;

case 4:
//if
this.state = 7;
if (anywheresoftware.b4a.keywords.Common.File.Exists(parent._vvvvvvvvvvvvvvvvv7.GetSafeDirDefaultExternal("cache"),_peganome_arquivo(_url))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 //BA.debugLineNum = 23;BA.debugLine="iv.SetBackgroundImage(LoadBitmapResize(rp.GetSa";
_iv.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapResize(parent._vvvvvvvvvvvvvvvvv7.GetSafeDirDefaultExternal("cache"),_peganome_arquivo(_url),_iv.getWidth(),_iv.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject())).setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
 //BA.debugLineNum = 24;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;

case 8:
//C
this.state = 9;
;
 //BA.debugLineNum = 27;BA.debugLine="Dim j As HttpJob";
_j = new com.kobe.code.arthur.httpjob();
 //BA.debugLineNum = 28;BA.debugLine="j.Initialize(\"\", Me)";
_j._initialize(processBA,"",getimage.getObject());
 //BA.debugLineNum = 29;BA.debugLine="j.Download(url)";
_j._vv7(_url);
 //BA.debugLineNum = 30;BA.debugLine="j.GetRequest.Timeout = 10000 'TIME OUT DE NO MÁXI";
_j._vvv6().setTimeout((int) (10000));
 //BA.debugLineNum = 31;BA.debugLine="Wait For (j) JobDone(j As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, this, (Object)(_j));
this.state = 32;
return;
case 32:
//C
this.state = 9;
_j = (com.kobe.code.arthur.httpjob) result[0];
;
 //BA.debugLineNum = 32;BA.debugLine="If j.Success Then";
if (true) break;

case 9:
//if
this.state = 31;
if (_j._vvvvv5) { 
this.state = 11;
}else {
this.state = 24;
}if (true) break;

case 11:
//C
this.state = 12;
 //BA.debugLineNum = 33;BA.debugLine="Try";
if (true) break;

case 12:
//try
this.state = 17;
this.catchState = 16;
this.state = 14;
if (true) break;

case 14:
//C
this.state = 17;
this.catchState = 16;
 //BA.debugLineNum = 34;BA.debugLine="Dim out As OutputStream = File.OpenOutput(rp.Ge";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
_out = anywheresoftware.b4a.keywords.Common.File.OpenOutput(parent._vvvvvvvvvvvvvvvvv7.GetSafeDirDefaultExternal("cache"),_peganome_arquivo(_url),anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 35;BA.debugLine="File.Copy2(j.GetInputStream, out)";
anywheresoftware.b4a.keywords.Common.File.Copy2((java.io.InputStream)(_j._vvv5().getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 36;BA.debugLine="out.Close 'IMPORTANTE FECHAR O OutputStream";
_out.Close();
 if (true) break;

case 16:
//C
this.state = 17;
this.catchState = 0;
 //BA.debugLineNum = 38;BA.debugLine="Log(\"erro ao salvar a imagem \"&PegaNome_Arquivo";
anywheresoftware.b4a.keywords.Common.Log("erro ao salvar a imagem "+_peganome_arquivo(_url)+" em cache!");
 if (true) break;
if (true) break;
;
 //BA.debugLineNum = 40;BA.debugLine="If iv.IsInitialized Then iv.SetBackgroundImage(j";

case 17:
//if
this.state = 22;
this.catchState = 0;
if (_iv.IsInitialized()) { 
this.state = 19;
;}if (true) break;

case 19:
//C
this.state = 22;
_iv.SetBackgroundImageNew((android.graphics.Bitmap)(_j._vvv2().Resize((float) (_iv.getWidth()),(float) (_iv.getHeight()),anywheresoftware.b4a.keywords.Common.True).getObject())).setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
if (true) break;

case 22:
//C
this.state = 31;
;
 if (true) break;

case 24:
//C
this.state = 25;
 //BA.debugLineNum = 42;BA.debugLine="If iv.IsInitialized Then iv.SetBackgroundImage(L";
if (true) break;

case 25:
//if
this.state = 30;
if (_iv.IsInitialized()) { 
this.state = 27;
;}if (true) break;

case 27:
//C
this.state = 30;
_iv.SetBackgroundImageNew((android.graphics.Bitmap)(anywheresoftware.b4a.keywords.Common.LoadBitmapResize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"semImagem.png",_iv.getWidth(),_iv.getHeight(),anywheresoftware.b4a.keywords.Common.True).getObject())).setGravity(anywheresoftware.b4a.keywords.Common.Gravity.CENTER);
if (true) break;

case 30:
//C
this.state = 31;
;
 if (true) break;

case 31:
//C
this.state = -1;
;
 //BA.debugLineNum = 44;BA.debugLine="j.Release";
_j._vvvvv3();
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
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
public static void  _jobdone(com.kobe.code.arthur.httpjob _j) throws Exception{
}
public static String  _peganome_arquivo(String _caminho) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Sub PegaNome_Arquivo(caminho As String) As String";
 //BA.debugLineNum = 49;BA.debugLine="Return caminho.SubString(caminho.LastIndexOf(\"/\")";
if (true) return _caminho.substring((int) (_caminho.lastIndexOf("/")+1));
 //BA.debugLineNum = 50;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 6;BA.debugLine="Private cacheAtivado As Boolean = True";
_vvvvvvvvvvvvvvvvv6 = anywheresoftware.b4a.keywords.Common.True;
 //BA.debugLineNum = 7;BA.debugLine="Private rp As RuntimePermissions";
_vvvvvvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.RuntimePermissions();
 //BA.debugLineNum = 8;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 10;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 18;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 14;BA.debugLine="Service.StopAutomaticForeground";
mostCurrent._service.StopAutomaticForeground();
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return "";
}
}
