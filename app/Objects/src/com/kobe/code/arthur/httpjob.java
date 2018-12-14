package com.kobe.code.arthur;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class httpjob extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.kobe.code.arthur.httpjob");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.kobe.code.arthur.httpjob.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public String _vvvvv4 = "";
public boolean _vvvvv5 = false;
public String _vvvvv6 = "";
public String _vvvvv7 = "";
public String _vvvvv0 = "";
public Object _vvvvvv1 = null;
public String _vvvvvv2 = "";
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest _vvvvvv3 = null;
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse _vvvvvv4 = null;
public Object _vvvvvv5 = null;
public com.kobe.code.arthur.main _vvvvvv6 = null;
public com.kobe.code.arthur.starter _vvvvvv7 = null;
public com.kobe.code.arthur.httputils2service _vvvvvv0 = null;
public com.kobe.code.arthur.getimage _vvvvvvv1 = null;
public static class _multipartfiledata{
public boolean IsInitialized;
public String Dir;
public String FileName;
public String KeyName;
public String ContentType;
public void Initialize() {
IsInitialized = true;
Dir = "";
FileName = "";
KeyName = "";
ContentType = "";
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 3;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 4;BA.debugLine="Public JobName As String";
_vvvvv4 = "";
 //BA.debugLineNum = 5;BA.debugLine="Public Success As Boolean";
_vvvvv5 = false;
 //BA.debugLineNum = 6;BA.debugLine="Public Username, Password As String";
_vvvvv6 = "";
_vvvvv7 = "";
 //BA.debugLineNum = 7;BA.debugLine="Public ErrorMessage As String";
_vvvvv0 = "";
 //BA.debugLineNum = 8;BA.debugLine="Private target As Object";
_vvvvvv1 = new Object();
 //BA.debugLineNum = 10;BA.debugLine="Private taskId As String";
_vvvvvv2 = "";
 //BA.debugLineNum = 11;BA.debugLine="Private req As OkHttpRequest";
_vvvvvv3 = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest();
 //BA.debugLineNum = 12;BA.debugLine="Public Response As OkHttpResponse";
_vvvvvv4 = new anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpResponse();
 //BA.debugLineNum = 17;BA.debugLine="Public Tag As Object";
_vvvvvv5 = new Object();
 //BA.debugLineNum = 18;BA.debugLine="Type MultipartFileData (Dir As String, FileName A";
;
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return "";
}
public String  _complete(int _id) throws Exception{
 //BA.debugLineNum = 240;BA.debugLine="Public Sub Complete (id As Int)";
 //BA.debugLineNum = 241;BA.debugLine="taskId = id";
_vvvvvv2 = BA.NumberToString(_id);
 //BA.debugLineNum = 242;BA.debugLine="CallSubDelayed2(target, \"JobDone\", Me)";
__c.CallSubDelayed2(ba,_vvvvvv1,"JobDone",this);
 //BA.debugLineNum = 243;BA.debugLine="End Sub";
return "";
}
public String  _vv5(String _link) throws Exception{
 //BA.debugLineNum = 198;BA.debugLine="Public Sub Delete(Link As String)";
 //BA.debugLineNum = 199;BA.debugLine="req.InitializeDelete(Link)";
_vvvvvv3.InitializeDelete(_link);
 //BA.debugLineNum = 200;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 201;BA.debugLine="End Sub";
return "";
}
public String  _vv6(String _link,String[] _parameters) throws Exception{
 //BA.debugLineNum = 203;BA.debugLine="Public Sub Delete2(Link As String, Parameters() As";
 //BA.debugLineNum = 204;BA.debugLine="req.InitializeDelete(escapeLink(Link, Parameters)";
_vvvvvv3.InitializeDelete(_vvv1(_link,_parameters));
 //BA.debugLineNum = 205;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 206;BA.debugLine="End Sub";
return "";
}
public String  _vv7(String _link) throws Exception{
 //BA.debugLineNum = 168;BA.debugLine="Public Sub Download(Link As String)";
 //BA.debugLineNum = 169;BA.debugLine="req.InitializeGet(Link)";
_vvvvvv3.InitializeGet(_link);
 //BA.debugLineNum = 170;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 171;BA.debugLine="End Sub";
return "";
}
public String  _vv0(String _link,String[] _parameters) throws Exception{
 //BA.debugLineNum = 178;BA.debugLine="Public Sub Download2(Link As String, Parameters()";
 //BA.debugLineNum = 179;BA.debugLine="req.InitializeGet(escapeLink(Link, Parameters))";
_vvvvvv3.InitializeGet(_vvv1(_link,_parameters));
 //BA.debugLineNum = 180;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 181;BA.debugLine="End Sub";
return "";
}
public String  _vvv1(String _link,String[] _parameters) throws Exception{
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
anywheresoftware.b4a.objects.StringUtils _su = null;
int _i = 0;
 //BA.debugLineNum = 183;BA.debugLine="Private Sub escapeLink(Link As String, Parameters(";
 //BA.debugLineNum = 184;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
 //BA.debugLineNum = 185;BA.debugLine="sb.Initialize";
_sb.Initialize();
 //BA.debugLineNum = 186;BA.debugLine="sb.Append(Link)";
_sb.Append(_link);
 //BA.debugLineNum = 187;BA.debugLine="If Parameters.Length > 0 Then sb.Append(\"?\")";
if (_parameters.length>0) { 
_sb.Append("?");};
 //BA.debugLineNum = 188;BA.debugLine="Dim su As StringUtils";
_su = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 189;BA.debugLine="For i = 0 To Parameters.Length - 1 Step 2";
{
final int step6 = 2;
final int limit6 = (int) (_parameters.length-1);
_i = (int) (0) ;
for (;_i <= limit6 ;_i = _i + step6 ) {
 //BA.debugLineNum = 190;BA.debugLine="If i > 0 Then sb.Append(\"&\")";
if (_i>0) { 
_sb.Append("&");};
 //BA.debugLineNum = 191;BA.debugLine="sb.Append(su.EncodeUrl(Parameters(i), \"UTF8\")).A";
_sb.Append(_su.EncodeUrl(_parameters[_i],"UTF8")).Append("=");
 //BA.debugLineNum = 192;BA.debugLine="sb.Append(su.EncodeUrl(Parameters(i + 1), \"UTF8\"";
_sb.Append(_su.EncodeUrl(_parameters[(int) (_i+1)],"UTF8"));
 }
};
 //BA.debugLineNum = 194;BA.debugLine="Return sb.ToString";
if (true) return _sb.ToString();
 //BA.debugLineNum = 195;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _vvv2() throws Exception{
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _b = null;
 //BA.debugLineNum = 255;BA.debugLine="Public Sub GetBitmap As Bitmap";
 //BA.debugLineNum = 256;BA.debugLine="Dim b As Bitmap";
_b = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 257;BA.debugLine="b = LoadBitmap(HttpUtils2Service.TempFolder, task";
_b = __c.LoadBitmap(_vvvvvv0._vv4,_vvvvvv2);
 //BA.debugLineNum = 258;BA.debugLine="Return b";
if (true) return _b;
 //BA.debugLineNum = 259;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _vvv3(int _width,int _height,boolean _keepaspectratio) throws Exception{
 //BA.debugLineNum = 266;BA.debugLine="Public Sub GetBitmapResize(Width As Int, Height As";
 //BA.debugLineNum = 267;BA.debugLine="Return LoadBitmapResize(HttpUtils2Service.TempFol";
if (true) return __c.LoadBitmapResize(_vvvvvv0._vv4,_vvvvvv2,_width,_height,_keepaspectratio);
 //BA.debugLineNum = 268;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper  _vvv4(int _width,int _height) throws Exception{
 //BA.debugLineNum = 262;BA.debugLine="Public Sub GetBitmapSample(Width As Int, Height As";
 //BA.debugLineNum = 263;BA.debugLine="Return LoadBitmapSample(HttpUtils2Service.TempFol";
if (true) return __c.LoadBitmapSample(_vvvvvv0._vv4,_vvvvvv2,_width,_height);
 //BA.debugLineNum = 264;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.streams.File.InputStreamWrapper  _vvv5() throws Exception{
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
 //BA.debugLineNum = 272;BA.debugLine="Public Sub GetInputStream As InputStream";
 //BA.debugLineNum = 273;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 274;BA.debugLine="In = File.OpenInput(HttpUtils2Service.TempFolder,";
_in = __c.File.OpenInput(_vvvvvv0._vv4,_vvvvvv2);
 //BA.debugLineNum = 275;BA.debugLine="Return In";
if (true) return _in;
 //BA.debugLineNum = 276;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4h.okhttp.OkHttpClientWrapper.OkHttpRequest  _vvv6() throws Exception{
 //BA.debugLineNum = 235;BA.debugLine="Public Sub GetRequest As OkHttpRequest";
 //BA.debugLineNum = 236;BA.debugLine="Return req";
if (true) return _vvvvvv3;
 //BA.debugLineNum = 237;BA.debugLine="End Sub";
return null;
}
public String  _vvv7() throws Exception{
 //BA.debugLineNum = 216;BA.debugLine="Public Sub GetString As String";
 //BA.debugLineNum = 217;BA.debugLine="Return GetString2(\"UTF8\")";
if (true) return _vvv0("UTF8");
 //BA.debugLineNum = 218;BA.debugLine="End Sub";
return "";
}
public String  _vvv0(String _encoding) throws Exception{
anywheresoftware.b4a.objects.streams.File.TextReaderWrapper _tr = null;
String _res = "";
 //BA.debugLineNum = 221;BA.debugLine="Public Sub GetString2(Encoding As String) As Strin";
 //BA.debugLineNum = 225;BA.debugLine="Dim tr As TextReader";
_tr = new anywheresoftware.b4a.objects.streams.File.TextReaderWrapper();
 //BA.debugLineNum = 226;BA.debugLine="tr.Initialize2(File.OpenInput(HttpUtils2Service.T";
_tr.Initialize2((java.io.InputStream)(__c.File.OpenInput(_vvvvvv0._vv4,_vvvvvv2).getObject()),_encoding);
 //BA.debugLineNum = 227;BA.debugLine="Dim res As String = tr.ReadAll";
_res = _tr.ReadAll();
 //BA.debugLineNum = 228;BA.debugLine="tr.Close";
_tr.Close();
 //BA.debugLineNum = 229;BA.debugLine="Return res";
if (true) return _res;
 //BA.debugLineNum = 231;BA.debugLine="End Sub";
return "";
}
public String  _vvvv1(String _link) throws Exception{
 //BA.debugLineNum = 75;BA.debugLine="Public Sub Head(Link As String)";
 //BA.debugLineNum = 76;BA.debugLine="req.InitializeHead(Link)";
_vvvvvv3.InitializeHead(_link);
 //BA.debugLineNum = 77;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public String  _initialize(anywheresoftware.b4a.BA _ba,String _name,Object _targetmodule) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 27;BA.debugLine="Public Sub Initialize (Name As String, TargetModul";
 //BA.debugLineNum = 28;BA.debugLine="JobName = Name";
_vvvvv4 = _name;
 //BA.debugLineNum = 29;BA.debugLine="target = TargetModule";
_vvvvvv1 = _targetmodule;
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return "";
}
public boolean  _vvvv2(anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream,boolean _empty) throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Private Sub MultipartStartSection (stream As Outpu";
 //BA.debugLineNum = 130;BA.debugLine="If empty = False Then";
if (_empty==__c.False) { 
 //BA.debugLineNum = 131;BA.debugLine="stream.WriteBytes(Array As Byte(13, 10), 0, 2)";
_stream.WriteBytes(new byte[]{(byte) (13),(byte) (10)},(int) (0),(int) (2));
 }else {
 //BA.debugLineNum = 133;BA.debugLine="empty = False";
_empty = __c.False;
 };
 //BA.debugLineNum = 135;BA.debugLine="Return empty";
if (true) return _empty;
 //BA.debugLineNum = 136;BA.debugLine="End Sub";
return false;
}
public String  _vvvv3(String _link,byte[] _data) throws Exception{
 //BA.debugLineNum = 59;BA.debugLine="Public Sub PatchBytes(Link As String, Data() As By";
 //BA.debugLineNum = 67;BA.debugLine="req.InitializePatch2(Link, Data)";
_vvvvvv3.InitializePatch2(_link,_data);
 //BA.debugLineNum = 70;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 71;BA.debugLine="End Sub";
return "";
}
public String  _vvvv4(String _link,String _text) throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Public Sub PatchString(Link As String, Text As Str";
 //BA.debugLineNum = 55;BA.debugLine="PatchBytes(Link, Text.GetBytes(\"UTF8\"))";
_vvvv3(_link,_text.getBytes("UTF8"));
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public String  _vvvv5(String _link,byte[] _data) throws Exception{
 //BA.debugLineNum = 37;BA.debugLine="Public Sub PostBytes(Link As String, Data() As Byt";
 //BA.debugLineNum = 38;BA.debugLine="req.InitializePost2(Link, Data)";
_vvvvvv3.InitializePost2(_link,_data);
 //BA.debugLineNum = 39;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 40;BA.debugLine="End Sub";
return "";
}
public String  _vvvv6(String _link,String _dir,String _filename) throws Exception{
int _length = 0;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _out = null;
 //BA.debugLineNum = 140;BA.debugLine="Public Sub PostFile(Link As String, Dir As String,";
 //BA.debugLineNum = 145;BA.debugLine="Dim length As Int";
_length = 0;
 //BA.debugLineNum = 146;BA.debugLine="If Dir = File.DirAssets Then";
if ((_dir).equals(__c.File.getDirAssets())) { 
 //BA.debugLineNum = 147;BA.debugLine="Log(\"Cannot send files from the assets folder.\")";
__c.Log("Cannot send files from the assets folder.");
 //BA.debugLineNum = 148;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 150;BA.debugLine="length = File.Size(Dir, FileName)";
_length = (int) (__c.File.Size(_dir,_filename));
 //BA.debugLineNum = 151;BA.debugLine="Dim In As InputStream";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
 //BA.debugLineNum = 152;BA.debugLine="In = File.OpenInput(Dir, FileName)";
_in = __c.File.OpenInput(_dir,_filename);
 //BA.debugLineNum = 153;BA.debugLine="If length < 1000000 Then '1mb";
if (_length<1000000) { 
 //BA.debugLineNum = 156;BA.debugLine="Dim out As OutputStream";
_out = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 157;BA.debugLine="out.InitializeToBytesArray(length)";
_out.InitializeToBytesArray(_length);
 //BA.debugLineNum = 158;BA.debugLine="File.Copy2(In, out)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_out.getObject()));
 //BA.debugLineNum = 159;BA.debugLine="PostBytes(Link, out.ToBytesArray)";
_vvvv5(_link,_out.ToBytesArray());
 }else {
 //BA.debugLineNum = 161;BA.debugLine="req.InitializePost(Link, In, length)";
_vvvvvv3.InitializePost(_link,(java.io.InputStream)(_in.getObject()),_length);
 //BA.debugLineNum = 162;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\",";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 };
 //BA.debugLineNum = 165;BA.debugLine="End Sub";
return "";
}
public String  _vvvv7(String _link,anywheresoftware.b4a.objects.collections.Map _namevalues,anywheresoftware.b4a.objects.collections.List _files) throws Exception{
String _boundary = "";
anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper _stream = null;
byte[] _b = null;
String _eol = "";
boolean _empty = false;
String _key = "";
String _value = "";
String _s = "";
com.kobe.code.arthur.httpjob._multipartfiledata _fd = null;
anywheresoftware.b4a.objects.streams.File.InputStreamWrapper _in = null;
 //BA.debugLineNum = 83;BA.debugLine="Public Sub PostMultipart(Link As String, NameValue";
 //BA.debugLineNum = 84;BA.debugLine="Dim boundary As String = \"-----------------------";
_boundary = "---------------------------1461124740692";
 //BA.debugLineNum = 85;BA.debugLine="Dim stream As OutputStream";
_stream = new anywheresoftware.b4a.objects.streams.File.OutputStreamWrapper();
 //BA.debugLineNum = 86;BA.debugLine="stream.InitializeToBytesArray(0)";
_stream.InitializeToBytesArray((int) (0));
 //BA.debugLineNum = 87;BA.debugLine="Dim b() As Byte";
_b = new byte[(int) (0)];
;
 //BA.debugLineNum = 88;BA.debugLine="Dim eol As String = Chr(13) & Chr(10)";
_eol = BA.ObjectToString(__c.Chr((int) (13)))+BA.ObjectToString(__c.Chr((int) (10)));
 //BA.debugLineNum = 89;BA.debugLine="Dim empty As Boolean = True";
_empty = __c.True;
 //BA.debugLineNum = 90;BA.debugLine="If NameValues <> Null And NameValues.IsInitialize";
if (_namevalues!= null && _namevalues.IsInitialized()) { 
 //BA.debugLineNum = 91;BA.debugLine="For Each key As String In NameValues.Keys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _namevalues.Keys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_key = BA.ObjectToString(group8.Get(index8));
 //BA.debugLineNum = 92;BA.debugLine="Dim value As String = NameValues.Get(key)";
_value = BA.ObjectToString(_namevalues.Get((Object)(_key)));
 //BA.debugLineNum = 93;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = _vvvv2(_stream,_empty);
 //BA.debugLineNum = 94;BA.debugLine="Dim s As String = _ $\"--${boundary} Content-Dis";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"\n"+"Content-Disposition: form-data; name=\""+__c.SmartStringFormatter("",(Object)(_key))+"\"\n"+"\n"+""+__c.SmartStringFormatter("",(Object)(_value))+"");
 //BA.debugLineNum = 99;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
 //BA.debugLineNum = 100;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 }
};
 };
 //BA.debugLineNum = 103;BA.debugLine="If Files <> Null And Files.IsInitialized Then";
if (_files!= null && _files.IsInitialized()) { 
 //BA.debugLineNum = 104;BA.debugLine="For Each fd As MultipartFileData In Files";
{
final anywheresoftware.b4a.BA.IterableList group17 = _files;
final int groupLen17 = group17.getSize()
;int index17 = 0;
;
for (; index17 < groupLen17;index17++){
_fd = (com.kobe.code.arthur.httpjob._multipartfiledata)(group17.Get(index17));
 //BA.debugLineNum = 105;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = _vvvv2(_stream,_empty);
 //BA.debugLineNum = 106;BA.debugLine="Dim s As String = _ $\"--${boundary} Content-Dis";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"\n"+"Content-Disposition: form-data; name=\""+__c.SmartStringFormatter("",(Object)(_fd.KeyName))+"\"; filename=\""+__c.SmartStringFormatter("",(Object)(_fd.FileName))+"\"\n"+"Content-Type: "+__c.SmartStringFormatter("",(Object)(_fd.ContentType))+"\n"+"\n"+"");
 //BA.debugLineNum = 112;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
 //BA.debugLineNum = 113;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 //BA.debugLineNum = 114;BA.debugLine="Dim in As InputStream = File.OpenInput(fd.Dir,";
_in = new anywheresoftware.b4a.objects.streams.File.InputStreamWrapper();
_in = __c.File.OpenInput(_fd.Dir,_fd.FileName);
 //BA.debugLineNum = 115;BA.debugLine="File.Copy2(in, stream)";
__c.File.Copy2((java.io.InputStream)(_in.getObject()),(java.io.OutputStream)(_stream.getObject()));
 }
};
 };
 //BA.debugLineNum = 118;BA.debugLine="empty = MultipartStartSection (stream, empty)";
_empty = _vvvv2(_stream,_empty);
 //BA.debugLineNum = 119;BA.debugLine="s = _ $\"--${boundary}-- \"$";
_s = ("--"+__c.SmartStringFormatter("",(Object)(_boundary))+"--\n"+"");
 //BA.debugLineNum = 122;BA.debugLine="b = s.Replace(CRLF, eol).GetBytes(\"UTF8\")";
_b = _s.replace(__c.CRLF,_eol).getBytes("UTF8");
 //BA.debugLineNum = 123;BA.debugLine="stream.WriteBytes(b, 0, b.Length)";
_stream.WriteBytes(_b,(int) (0),_b.length);
 //BA.debugLineNum = 124;BA.debugLine="PostBytes(Link, stream.ToBytesArray)";
_vvvv5(_link,_stream.ToBytesArray());
 //BA.debugLineNum = 125;BA.debugLine="req.SetContentType(\"multipart/form-data; boundary";
_vvvvvv3.SetContentType("multipart/form-data; boundary="+_boundary);
 //BA.debugLineNum = 126;BA.debugLine="req.SetContentEncoding(\"UTF8\")";
_vvvvvv3.SetContentEncoding("UTF8");
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public String  _vvvv0(String _link,String _text) throws Exception{
 //BA.debugLineNum = 32;BA.debugLine="Public Sub PostString(Link As String, Text As Stri";
 //BA.debugLineNum = 33;BA.debugLine="PostBytes(Link, Text.GetBytes(\"UTF8\"))";
_vvvv5(_link,_text.getBytes("UTF8"));
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public String  _vvvvv1(String _link,byte[] _data) throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Public Sub PutBytes(Link As String, Data() As Byte";
 //BA.debugLineNum = 49;BA.debugLine="req.InitializePut2(Link, Data)";
_vvvvvv3.InitializePut2(_link,_data);
 //BA.debugLineNum = 50;BA.debugLine="CallSubDelayed2(HttpUtils2Service, \"SubmitJob\", M";
__c.CallSubDelayed2(ba,(Object)(_vvvvvv0.getObject()),"SubmitJob",this);
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public String  _vvvvv2(String _link,String _text) throws Exception{
 //BA.debugLineNum = 43;BA.debugLine="Public Sub PutString(Link As String, Text As Strin";
 //BA.debugLineNum = 44;BA.debugLine="PutBytes(Link, Text.GetBytes(\"UTF8\"))";
_vvvvv1(_link,_text.getBytes("UTF8"));
 //BA.debugLineNum = 45;BA.debugLine="End Sub";
return "";
}
public String  _vvvvv3() throws Exception{
 //BA.debugLineNum = 209;BA.debugLine="Public Sub Release";
 //BA.debugLineNum = 211;BA.debugLine="File.Delete(HttpUtils2Service.TempFolder, taskId)";
__c.File.Delete(_vvvvvv0._vv4,_vvvvvv2);
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
