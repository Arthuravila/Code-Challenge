package com.kobe.code.arthur;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class customlistview extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    private static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new BA(_ba, this, htSubs, "com.kobe.code.arthur.customlistview");
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            
        }
        if (BA.isShellModeRuntimeCheck(ba)) 
			   this.getClass().getMethod("_class_globals", com.kobe.code.arthur.customlistview.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvv4 = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _vvvvvvvvvvvv5 = null;
public anywheresoftware.b4a.objects.collections.List _vvvvvvvvvvvv6 = null;
public float _vvvvvvvvvvvv7 = 0f;
public String _vvvvvvvvvvvv0 = "";
public Object _vvvvvvvvvvvvv1 = null;
public int _vvvvvvvvvvvvv2 = 0;
public int _vvvvvvvvvvvvv3 = 0;
public int _vvvvvvvvvvvvv4 = 0;
public long _vvvvvvvvvvvvv5 = 0L;
public int _vvvvvvvvvvvvv6 = 0;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _vvvvvvvvvvvvv7 = null;
public anywheresoftware.b4a.objects.LabelWrapper _vvvvvvvvvvvvv0 = null;
public boolean _vvvvvvvvvvvvvv1 = false;
public anywheresoftware.b4a.objects.StringUtils _vv3 = null;
public int _vvvvvvvvvvvvvv2 = 0;
public int _vvvvvvvvvvvvvv3 = 0;
public boolean _vvvvvvvvvvvvvv4 = false;
public boolean _vvvvvvvvvvvvvv5 = false;
public boolean _vvvvvvvvvvvvvv6 = false;
public com.kobe.code.arthur.main _vvvvvv6 = null;
public com.kobe.code.arthur.starter _vvvvvv7 = null;
public com.kobe.code.arthur.httputils2service _vvvvvv0 = null;
public com.kobe.code.arthur.getimage _vvvvvvv1 = null;
public static class _clvitem{
public boolean IsInitialized;
public anywheresoftware.b4a.objects.B4XViewWrapper Panel;
public int Size;
public Object Value;
public int Color;
public boolean TextItem;
public int Offset;
public void Initialize() {
IsInitialized = true;
Panel = new anywheresoftware.b4a.objects.B4XViewWrapper();
Size = 0;
Value = new Object();
Color = 0;
TextItem = false;
Offset = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public String  _vvvvvvv2(anywheresoftware.b4a.objects.B4XViewWrapper _pnl,Object _value) throws Exception{
 //BA.debugLineNum = 371;BA.debugLine="Public Sub Add(Pnl As B4XView, Value As Object)";
 //BA.debugLineNum = 372;BA.debugLine="InsertAt(items.Size, Pnl, Value)";
_vvvvvvvvv0(_vvvvvvvvvvvv6.getSize(),_pnl,_value);
 //BA.debugLineNum = 373;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvv3(Object _text,Object _value) throws Exception{
 //BA.debugLineNum = 182;BA.debugLine="Public Sub AddTextItem(Text As Object, Value As Ob";
 //BA.debugLineNum = 183;BA.debugLine="InsertAtTextItem(items.Size, Text, Value)";
_vvvvvvvvvv2(_vvvvvvvvvvvv6.getSize(),_text,_value);
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvv4() throws Exception{
 //BA.debugLineNum = 124;BA.debugLine="Public Sub AsView As B4XView";
 //BA.debugLineNum = 125;BA.debugLine="Return mBase";
if (true) return _vvvvvvvvvvvv4;
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return null;
}
public String  _base_resize(double _width,double _height) throws Exception{
int _scrollbar = 0;
com.kobe.code.arthur.customlistview._clvitem _it = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
 //BA.debugLineNum = 100;BA.debugLine="Public Sub Base_Resize (Width As Double, Height As";
 //BA.debugLineNum = 101;BA.debugLine="sv.SetLayoutAnimated(0, 0, 0, Width, Height)";
_vvvvvvvvvvvv5.SetLayoutAnimated((int) (0),(int) (0),(int) (0),(int) (_width),(int) (_height));
 //BA.debugLineNum = 102;BA.debugLine="Dim scrollbar As Int";
_scrollbar = 0;
 //BA.debugLineNum = 103;BA.debugLine="If xui.IsB4J And ScrollBarsVisible Then scrollbar";
if (_vvvvvvvvvvvvv7.getIsB4J() && _vvvvvvvvvvvvvv6) { 
_scrollbar = (int) (20);};
 //BA.debugLineNum = 104;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 105;BA.debugLine="sv.ScrollViewContentHeight = Height - scrollbar";
_vvvvvvvvvvvv5.setScrollViewContentHeight((int) (_height-_scrollbar));
 //BA.debugLineNum = 106;BA.debugLine="For Each it As CLVItem In items";
{
final anywheresoftware.b4a.BA.IterableList group6 = _vvvvvvvvvvvv6;
final int groupLen6 = group6.getSize()
;int index6 = 0;
;
for (; index6 < groupLen6;index6++){
_it = (com.kobe.code.arthur.customlistview._clvitem)(group6.Get(index6));
 //BA.debugLineNum = 107;BA.debugLine="it.Panel.Height = sv.ScrollViewContentHeight";
_it.Panel.setHeight(_vvvvvvvvvvvv5.getScrollViewContentHeight());
 //BA.debugLineNum = 108;BA.debugLine="it.Panel.GetView(0).Height = it.Panel.Height";
_it.Panel.GetView((int) (0)).setHeight(_it.Panel.getHeight());
 }
};
 }else {
 //BA.debugLineNum = 111;BA.debugLine="sv.ScrollViewContentWidth = Width - scrollbar";
_vvvvvvvvvvvv5.setScrollViewContentWidth((int) (_width-_scrollbar));
 //BA.debugLineNum = 112;BA.debugLine="For Each it As CLVItem In items";
{
final anywheresoftware.b4a.BA.IterableList group12 = _vvvvvvvvvvvv6;
final int groupLen12 = group12.getSize()
;int index12 = 0;
;
for (; index12 < groupLen12;index12++){
_it = (com.kobe.code.arthur.customlistview._clvitem)(group12.Get(index12));
 //BA.debugLineNum = 113;BA.debugLine="it.Panel.Width = sv.ScrollViewContentWidth";
_it.Panel.setWidth(_vvvvvvvvvvvv5.getScrollViewContentWidth());
 //BA.debugLineNum = 114;BA.debugLine="it.Panel.GetView(0).Width = it.Panel.Width";
_it.Panel.GetView((int) (0)).setWidth(_it.Panel.getWidth());
 //BA.debugLineNum = 115;BA.debugLine="If it.TextItem Then";
if (_it.TextItem) { 
 //BA.debugLineNum = 116;BA.debugLine="Dim lbl As B4XView = it.Panel.GetView(0).GetVi";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _it.Panel.GetView((int) (0)).GetView((int) (0));
 //BA.debugLineNum = 117;BA.debugLine="lbl.SetLayoutAnimated(0, lbl.Left, lbl.Top, it";
_lbl.SetLayoutAnimated((int) (0),_lbl.getLeft(),_lbl.getTop(),(int) (_it.Panel.getWidth()-_lbl.getLeft()),_lbl.getHeight());
 };
 }
};
 };
 //BA.debugLineNum = 121;BA.debugLine="If items.Size > 0 Then UpdateVisibleRange";
if (_vvvvvvvvvvvv6.getSize()>0) { 
_vvvvvvvvvvv7();};
 //BA.debugLineNum = 122;BA.debugLine="End Sub";
return "";
}
public String  _class_globals() throws Exception{
 //BA.debugLineNum = 13;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 14;BA.debugLine="Private mBase As B4XView";
_vvvvvvvvvvvv4 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Public sv As B4XView";
_vvvvvvvvvvvv5 = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Type CLVItem(Panel As B4XView, Size As Int, Value";
;
 //BA.debugLineNum = 18;BA.debugLine="Private items As List";
_vvvvvvvvvvvv6 = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 19;BA.debugLine="Private mDividerSize As Float";
_vvvvvvvvvvvv7 = 0f;
 //BA.debugLineNum = 20;BA.debugLine="Private EventName As String";
_vvvvvvvvvvvv0 = "";
 //BA.debugLineNum = 21;BA.debugLine="Private CallBack As Object";
_vvvvvvvvvvvvv1 = new Object();
 //BA.debugLineNum = 22;BA.debugLine="Public DefaultTextColor As Int";
_vvvvvvvvvvvvv2 = 0;
 //BA.debugLineNum = 23;BA.debugLine="Public DefaultTextBackgroundColor As Int";
_vvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 24;BA.debugLine="Public AnimationDuration As Int = 300";
_vvvvvvvvvvvvv4 = (int) (300);
 //BA.debugLineNum = 25;BA.debugLine="Private LastReachEndEvent As Long";
_vvvvvvvvvvvvv5 = 0L;
 //BA.debugLineNum = 26;BA.debugLine="Private PressedColor As Int";
_vvvvvvvvvvvvv6 = 0;
 //BA.debugLineNum = 27;BA.debugLine="Private xui As XUI";
_vvvvvvvvvvvvv7 = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
 //BA.debugLineNum = 28;BA.debugLine="Private DesignerLabel As Label";
_vvvvvvvvvvvvv0 = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 29;BA.debugLine="Private horizontal As Boolean";
_vvvvvvvvvvvvvv1 = false;
 //BA.debugLineNum = 33;BA.debugLine="Private su As StringUtils";
_vv3 = new anywheresoftware.b4a.objects.StringUtils();
 //BA.debugLineNum = 37;BA.debugLine="Private mFirstVisibleIndex, mLastVisibleIndex As";
_vvvvvvvvvvvvvv2 = 0;
_vvvvvvvvvvvvvv3 = 0;
 //BA.debugLineNum = 38;BA.debugLine="Private MonitorVisibleRange As Boolean";
_vvvvvvvvvvvvvv4 = false;
 //BA.debugLineNum = 39;BA.debugLine="Private FireScrollChanged As Boolean";
_vvvvvvvvvvvvvv5 = false;
 //BA.debugLineNum = 40;BA.debugLine="Private ScrollBarsVisible As Boolean";
_vvvvvvvvvvvvvv6 = false;
 //BA.debugLineNum = 41;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvv5() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Public Sub Clear";
 //BA.debugLineNum = 130;BA.debugLine="items.Clear";
_vvvvvvvvvvvv6.Clear();
 //BA.debugLineNum = 131;BA.debugLine="sv.ScrollViewInnerPanel.RemoveAllViews";
_vvvvvvvvvvvv5.getScrollViewInnerPanel().RemoveAllViews();
 //BA.debugLineNum = 132;BA.debugLine="SetScrollViewContentSize(0)";
_vvvvvvvvvvv5((float) (0));
 //BA.debugLineNum = 133;BA.debugLine="ResetVisibles";
_vvvvvvvvvv0();
 //BA.debugLineNum = 134;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvv6(Object _txt) throws Exception{
anywheresoftware.b4a.objects.LabelWrapper _lbl = null;
 //BA.debugLineNum = 524;BA.debugLine="Private Sub CreateLabel(txt As Object) As B4XView";
 //BA.debugLineNum = 525;BA.debugLine="Dim lbl As Label";
_lbl = new anywheresoftware.b4a.objects.LabelWrapper();
 //BA.debugLineNum = 526;BA.debugLine="lbl.Initialize(\"\")";
_lbl.Initialize(ba,"");
 //BA.debugLineNum = 527;BA.debugLine="lbl.Gravity = DesignerLabel.Gravity";
_lbl.setGravity(_vvvvvvvvvvvvv0.getGravity());
 //BA.debugLineNum = 528;BA.debugLine="lbl.TextSize = DesignerLabel.TextSize";
_lbl.setTextSize(_vvvvvvvvvvvvv0.getTextSize());
 //BA.debugLineNum = 529;BA.debugLine="lbl.SingleLine = False";
_lbl.setSingleLine(__c.False);
 //BA.debugLineNum = 530;BA.debugLine="lbl.Text = txt";
_lbl.setText(BA.ObjectToCharSequence(_txt));
 //BA.debugLineNum = 531;BA.debugLine="lbl.Width = sv.ScrollViewContentWidth - 10dip";
_lbl.setWidth((int) (_vvvvvvvvvvvv5.getScrollViewContentWidth()-__c.DipToCurrent((int) (10))));
 //BA.debugLineNum = 532;BA.debugLine="lbl.Height = su.MeasureMultilineTextHeight(lbl, t";
_lbl.setHeight(_vv3.MeasureMultilineTextHeight((android.widget.TextView)(_lbl.getObject()),BA.ObjectToCharSequence(_txt)));
 //BA.debugLineNum = 533;BA.debugLine="Return lbl";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_lbl.getObject()));
 //BA.debugLineNum = 534;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvv7(String _paneleventname) throws Exception{
 //BA.debugLineNum = 491;BA.debugLine="Private Sub CreatePanel (PanelEventName As String)";
 //BA.debugLineNum = 492;BA.debugLine="Return xui.CreatePanel(PanelEventName)";
if (true) return _vvvvvvvvvvvvv7.CreatePanel(ba,_paneleventname);
 //BA.debugLineNum = 493;BA.debugLine="End Sub";
return null;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvv0() throws Exception{
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hv = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _nsv = null;
 //BA.debugLineNum = 504;BA.debugLine="Private Sub CreateScrollView As B4XView";
 //BA.debugLineNum = 505;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 506;BA.debugLine="Dim hv As HorizontalScrollView";
_hv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
 //BA.debugLineNum = 507;BA.debugLine="hv.Initialize(0, \"sv\")";
_hv.Initialize(ba,(int) (0),"sv");
 //BA.debugLineNum = 508;BA.debugLine="Return hv";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_hv.getObject()));
 }else {
 //BA.debugLineNum = 510;BA.debugLine="Dim nsv As ScrollView";
_nsv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
 //BA.debugLineNum = 511;BA.debugLine="nsv.Initialize2(0, \"sv\")";
_nsv.Initialize2(ba,(int) (0),"sv");
 //BA.debugLineNum = 512;BA.debugLine="Return nsv";
if (true) return (anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(_nsv.getObject()));
 };
 //BA.debugLineNum = 514;BA.debugLine="End Sub";
return null;
}
public String  _designercreateview(Object _base,anywheresoftware.b4a.objects.LabelWrapper _lbl,anywheresoftware.b4a.objects.collections.Map _props) throws Exception{
String _o = "";
anywheresoftware.b4j.object.JavaObject _jsv = null;
 //BA.debugLineNum = 65;BA.debugLine="Public Sub DesignerCreateView (Base As Object, Lbl";
 //BA.debugLineNum = 66;BA.debugLine="mBase = Base";
_vvvvvvvvvvvv4.setObject((java.lang.Object)(_base));
 //BA.debugLineNum = 67;BA.debugLine="Dim o As String = Props.GetDefault(\"ListOrientati";
_o = BA.ObjectToString(_props.GetDefault((Object)("ListOrientation"),(Object)("Vertical")));
 //BA.debugLineNum = 68;BA.debugLine="horizontal = o = \"Horizontal\"";
_vvvvvvvvvvvvvv1 = (_o).equals("Horizontal");
 //BA.debugLineNum = 69;BA.debugLine="sv = CreateScrollView";
_vvvvvvvvvvvv5 = _vvvvvvv0();
 //BA.debugLineNum = 70;BA.debugLine="mBase.AddView(sv, 0, 0, mBase.Width, mBase.Height";
_vvvvvvvvvvvv4.AddView((android.view.View)(_vvvvvvvvvvvv5.getObject()),(int) (0),(int) (0),_vvvvvvvvvvvv4.getWidth(),_vvvvvvvvvvvv4.getHeight());
 //BA.debugLineNum = 71;BA.debugLine="sv.ScrollViewInnerPanel.Color = xui.PaintOrColorT";
_vvvvvvvvvvvv5.getScrollViewInnerPanel().setColor(_vvvvvvvvvvvvv7.PaintOrColorToColor(_props.Get((Object)("DividerColor"))));
 //BA.debugLineNum = 72;BA.debugLine="mDividerSize = DipToCurrent(Props.Get(\"DividerHei";
_vvvvvvvvvvvv7 = (float) (__c.DipToCurrent((int)(BA.ObjectToNumber(_props.Get((Object)("DividerHeight"))))));
 //BA.debugLineNum = 73;BA.debugLine="PressedColor = xui.PaintOrColorToColor(Props.Get(";
_vvvvvvvvvvvvv6 = _vvvvvvvvvvvvv7.PaintOrColorToColor(_props.Get((Object)("PressedColor")));
 //BA.debugLineNum = 74;BA.debugLine="AnimationDuration = Props.GetDefault(\"InsertAnima";
_vvvvvvvvvvvvv4 = (int)(BA.ObjectToNumber(_props.GetDefault((Object)("InsertAnimationDuration"),(Object)(_vvvvvvvvvvvvv4))));
 //BA.debugLineNum = 75;BA.debugLine="ScrollBarsVisible = Props.GetDefault(\"ShowScrollB";
_vvvvvvvvvvvvvv6 = BA.ObjectToBoolean(_props.GetDefault((Object)("ShowScrollBar"),(Object)(__c.True)));
 //BA.debugLineNum = 76;BA.debugLine="If ScrollBarsVisible = False Then";
if (_vvvvvvvvvvvvvv6==__c.False) { 
 //BA.debugLineNum = 82;BA.debugLine="Dim jsv As JavaObject = sv";
_jsv = new anywheresoftware.b4j.object.JavaObject();
_jsv.setObject((java.lang.Object)(_vvvvvvvvvvvv5.getObject()));
 //BA.debugLineNum = 83;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 84;BA.debugLine="jsv.RunMethod(\"setHorizontalScrollBarEnabled\",";
_jsv.RunMethod("setHorizontalScrollBarEnabled",new Object[]{(Object)(__c.False)});
 }else {
 //BA.debugLineNum = 86;BA.debugLine="jsv.RunMethod(\"setVerticalScrollBarEnabled\", Ar";
_jsv.RunMethod("setVerticalScrollBarEnabled",new Object[]{(Object)(__c.False)});
 };
 };
 //BA.debugLineNum = 94;BA.debugLine="DefaultTextColor = xui.PaintOrColorToColor(Lbl.Te";
_vvvvvvvvvvvvv2 = _vvvvvvvvvvvvv7.PaintOrColorToColor((Object)(_lbl.getTextColor()));
 //BA.debugLineNum = 95;BA.debugLine="DefaultTextBackgroundColor = mBase.Color";
_vvvvvvvvvvvvv3 = _vvvvvvvvvvvv4.getColor();
 //BA.debugLineNum = 96;BA.debugLine="DesignerLabel = Lbl";
_vvvvvvvvvvvvv0 = _lbl;
 //BA.debugLineNum = 97;BA.debugLine="Base_Resize(mBase.Width, mBase.Height)";
_base_resize(_vvvvvvvvvvvv4.getWidth(),_vvvvvvvvvvvv4.getHeight());
 //BA.debugLineNum = 98;BA.debugLine="End Sub";
return "";
}
public int  _vvvvvvvv1(int _offset) throws Exception{
int _position = 0;
int _stepsize = 0;
com.kobe.code.arthur.customlistview._clvitem _currentitem = null;
int _nextoffset = 0;
int _prevoffset = 0;
 //BA.debugLineNum = 413;BA.debugLine="Public Sub FindIndexFromOffset(Offset As Int) As I";
 //BA.debugLineNum = 415;BA.debugLine="Dim Position As Int = items.Size / 2";
_position = (int) (_vvvvvvvvvvvv6.getSize()/(double)2);
 //BA.debugLineNum = 416;BA.debugLine="Dim StepSize As Int = Ceil(Position / 2)";
_stepsize = (int) (__c.Ceil(_position/(double)2));
 //BA.debugLineNum = 417;BA.debugLine="Do While True";
while (__c.True) {
 //BA.debugLineNum = 418;BA.debugLine="Dim CurrentItem As CLVItem = items.Get(Position)";
_currentitem = (com.kobe.code.arthur.customlistview._clvitem)(_vvvvvvvvvvvv6.Get(_position));
 //BA.debugLineNum = 419;BA.debugLine="Dim NextOffset As Int";
_nextoffset = 0;
 //BA.debugLineNum = 420;BA.debugLine="If Position < items.Size - 1 Then";
if (_position<_vvvvvvvvvvvv6.getSize()-1) { 
 //BA.debugLineNum = 421;BA.debugLine="NextOffset = GetRawListItem(Position + 1).Offse";
_nextoffset = (int) (_vvvvvvvvv2((int) (_position+1)).Offset-1);
 }else {
 //BA.debugLineNum = 423;BA.debugLine="NextOffset = 0x7FFFFFFF";
_nextoffset = (int) (0x7fffffff);
 };
 //BA.debugLineNum = 425;BA.debugLine="Dim PrevOffset As Int";
_prevoffset = 0;
 //BA.debugLineNum = 426;BA.debugLine="If Position = 0 Then";
if (_position==0) { 
 //BA.debugLineNum = 427;BA.debugLine="PrevOffset = 0x80000000";
_prevoffset = (int) (0x80000000);
 }else {
 //BA.debugLineNum = 429;BA.debugLine="PrevOffset = CurrentItem.Offset";
_prevoffset = _currentitem.Offset;
 };
 //BA.debugLineNum = 431;BA.debugLine="If Offset > NextOffset Then";
if (_offset>_nextoffset) { 
 //BA.debugLineNum = 432;BA.debugLine="Position = Min(Position + StepSize, items.Size";
_position = (int) (__c.Min(_position+_stepsize,_vvvvvvvvvvvv6.getSize()-1));
 }else if(_offset<_prevoffset) { 
 //BA.debugLineNum = 434;BA.debugLine="Position = Max(Position - StepSize, 0)";
_position = (int) (__c.Max(_position-_stepsize,0));
 }else {
 //BA.debugLineNum = 436;BA.debugLine="Return Position";
if (true) return _position;
 };
 //BA.debugLineNum = 438;BA.debugLine="StepSize = Ceil(StepSize / 2)";
_stepsize = (int) (__c.Ceil(_stepsize/(double)2));
 }
;
 //BA.debugLineNum = 440;BA.debugLine="Return -1";
if (true) return (int) (-1);
 //BA.debugLineNum = 441;BA.debugLine="End Sub";
return 0;
}
public int  _vvvvvvvv2(int _index) throws Exception{
 //BA.debugLineNum = 408;BA.debugLine="Private Sub FindItemOffset(Index As Int) As Int";
 //BA.debugLineNum = 409;BA.debugLine="Return GetRawListItem(Index).Offset";
if (true) return _vvvvvvvvv2(_index).Offset;
 //BA.debugLineNum = 410;BA.debugLine="End Sub";
return 0;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvvv3() throws Exception{
 //BA.debugLineNum = 136;BA.debugLine="Public Sub GetBase As B4XView";
 //BA.debugLineNum = 137;BA.debugLine="Return mBase";
if (true) return _vvvvvvvvvvvv4;
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return null;
}
public float  _getvvvvvvvvvvv0() throws Exception{
 //BA.debugLineNum = 495;BA.debugLine="Public Sub getDividerSize As Float";
 //BA.debugLineNum = 496;BA.debugLine="Return mDividerSize";
if (true) return _vvvvvvvvvvvv7;
 //BA.debugLineNum = 497;BA.debugLine="End Sub";
return 0f;
}
public int  _getvvvvvvvvvvvv1() throws Exception{
 //BA.debugLineNum = 444;BA.debugLine="Public Sub getFirstVisibleIndex As Int";
 //BA.debugLineNum = 445;BA.debugLine="Return FindIndexFromOffset(GetScrollViewOffset +";
if (true) return _vvvvvvvv1((int) (_vvvvvvvvv4()+_vvvvvvvvvvvv7));
 //BA.debugLineNum = 446;BA.debugLine="End Sub";
return 0;
}
public int  _vvvvvvvv6(anywheresoftware.b4a.objects.B4XViewWrapper _v) throws Exception{
Object _parent = null;
anywheresoftware.b4a.objects.B4XViewWrapper _current = null;
 //BA.debugLineNum = 464;BA.debugLine="Public Sub GetItemFromView(v As B4XView) As Int";
 //BA.debugLineNum = 465;BA.debugLine="Dim parent = v As Object, current As B4XView";
_parent = (Object)(_v.getObject());
_current = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 466;BA.debugLine="Do While sv.ScrollViewInnerPanel <> parent";
while ((_vvvvvvvvvvvv5.getScrollViewInnerPanel()).equals((java.lang.Object)(_parent)) == false) {
 //BA.debugLineNum = 467;BA.debugLine="current = parent";
_current.setObject((java.lang.Object)(_parent));
 //BA.debugLineNum = 468;BA.debugLine="parent = current.Parent";
_parent = (Object)(_current.getParent().getObject());
 }
;
 //BA.debugLineNum = 470;BA.debugLine="v = current";
_v = _current;
 //BA.debugLineNum = 471;BA.debugLine="Return v.Tag";
if (true) return (int)(BA.ObjectToNumber(_v.getTag()));
 //BA.debugLineNum = 472;BA.debugLine="End Sub";
return 0;
}
public int  _getvvvvvvvvvvvv2() throws Exception{
 //BA.debugLineNum = 449;BA.debugLine="Public Sub getLastVisibleIndex As Int";
 //BA.debugLineNum = 450;BA.debugLine="Return FindIndexFromOffset(GetScrollViewOffset +";
if (true) return _vvvvvvvv1((int) (_vvvvvvvvv4()+_vvvvvvvvv5()));
 //BA.debugLineNum = 451;BA.debugLine="End Sub";
return 0;
}
public float  _vvvvvvvv0() throws Exception{
 //BA.debugLineNum = 380;BA.debugLine="Private Sub GetMaxScrollOffset As Float";
 //BA.debugLineNum = 381;BA.debugLine="Return GetScrollViewContentSize - GetScrollViewVi";
if (true) return (float) (_vvvvvvvvv3()-_vvvvvvvvv5());
 //BA.debugLineNum = 382;BA.debugLine="End Sub";
return 0f;
}
public anywheresoftware.b4a.objects.B4XViewWrapper  _vvvvvvvvv1(int _index) throws Exception{
 //BA.debugLineNum = 151;BA.debugLine="Public Sub GetPanel(Index As Int) As B4XView";
 //BA.debugLineNum = 152;BA.debugLine="Return GetRawListItem(Index).Panel.GetView(0)";
if (true) return _vvvvvvvvv2(_index).Panel.GetView((int) (0));
 //BA.debugLineNum = 153;BA.debugLine="End Sub";
return null;
}
public com.kobe.code.arthur.customlistview._clvitem  _vvvvvvvvv2(int _index) throws Exception{
 //BA.debugLineNum = 146;BA.debugLine="Public Sub GetRawListItem(Index As Int) As CLVItem";
 //BA.debugLineNum = 147;BA.debugLine="Return items.Get(Index)";
if (true) return (com.kobe.code.arthur.customlistview._clvitem)(_vvvvvvvvvvvv6.Get(_index));
 //BA.debugLineNum = 148;BA.debugLine="End Sub";
return null;
}
public float  _vvvvvvvvv3() throws Exception{
 //BA.debugLineNum = 324;BA.debugLine="Private Sub GetScrollViewContentSize As Float";
 //BA.debugLineNum = 325;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 326;BA.debugLine="Return sv.ScrollViewContentWidth";
if (true) return (float) (_vvvvvvvvvvvv5.getScrollViewContentWidth());
 }else {
 //BA.debugLineNum = 328;BA.debugLine="Return sv.ScrollViewContentHeight";
if (true) return (float) (_vvvvvvvvvvvv5.getScrollViewContentHeight());
 };
 //BA.debugLineNum = 330;BA.debugLine="End Sub";
return 0f;
}
public float  _vvvvvvvvv4() throws Exception{
 //BA.debugLineNum = 308;BA.debugLine="Private Sub GetScrollViewOffset As Float";
 //BA.debugLineNum = 309;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 310;BA.debugLine="Return sv.ScrollViewOffsetX";
if (true) return (float) (_vvvvvvvvvvvv5.getScrollViewOffsetX());
 }else {
 //BA.debugLineNum = 312;BA.debugLine="Return sv.ScrollViewOffsetY";
if (true) return (float) (_vvvvvvvvvvvv5.getScrollViewOffsetY());
 };
 //BA.debugLineNum = 314;BA.debugLine="End Sub";
return 0f;
}
public float  _vvvvvvvvv5() throws Exception{
 //BA.debugLineNum = 300;BA.debugLine="Private Sub GetScrollViewVisibleSize As Float";
 //BA.debugLineNum = 301;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 302;BA.debugLine="Return sv.Width";
if (true) return (float) (_vvvvvvvvvvvv5.getWidth());
 }else {
 //BA.debugLineNum = 304;BA.debugLine="Return sv.Height";
if (true) return (float) (_vvvvvvvvvvvv5.getHeight());
 };
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return 0f;
}
public int  _getvvvvvvvvvvvv3() throws Exception{
 //BA.debugLineNum = 141;BA.debugLine="Public Sub getSize As Int";
 //BA.debugLineNum = 142;BA.debugLine="Return items.Size";
if (true) return _vvvvvvvvvvvv6.getSize();
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return 0;
}
public Object  _vvvvvvvvv7(int _index) throws Exception{
 //BA.debugLineNum = 156;BA.debugLine="Public Sub GetValue(Index As Int) As Object";
 //BA.debugLineNum = 157;BA.debugLine="Return GetRawListItem(Index).Value";
if (true) return _vvvvvvvvv2(_index).Value;
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return null;
}
public String  _initialize(anywheresoftware.b4a.BA _ba,Object _vcallback,String _veventname) throws Exception{
innerInitialize(_ba);
 //BA.debugLineNum = 43;BA.debugLine="Public Sub Initialize (vCallBack As Object, vEvent";
 //BA.debugLineNum = 44;BA.debugLine="EventName = vEventName";
_vvvvvvvvvvvv0 = _veventname;
 //BA.debugLineNum = 45;BA.debugLine="CallBack = vCallBack";
_vvvvvvvvvvvvv1 = _vcallback;
 //BA.debugLineNum = 46;BA.debugLine="items.Initialize";
_vvvvvvvvvvvv6.Initialize();
 //BA.debugLineNum = 47;BA.debugLine="DefaultTextBackgroundColor = xui.Color_White";
_vvvvvvvvvvvvv3 = _vvvvvvvvvvvvv7.Color_White;
 //BA.debugLineNum = 48;BA.debugLine="DefaultTextColor = xui.Color_Black";
_vvvvvvvvvvvvv2 = _vvvvvvvvvvvvv7.Color_Black;
 //BA.debugLineNum = 49;BA.debugLine="MonitorVisibleRange = xui.SubExists(CallBack, Eve";
_vvvvvvvvvvvvvv4 = _vvvvvvvvvvvvv7.SubExists(ba,_vvvvvvvvvvvvv1,_vvvvvvvvvvvv0+"_VisibleRangeChanged",(int) (2));
 //BA.debugLineNum = 50;BA.debugLine="FireScrollChanged = xui.SubExists(CallBack, Event";
_vvvvvvvvvvvvvv5 = _vvvvvvvvvvvvv7.SubExists(ba,_vvvvvvvvvvvvv1,_vvvvvvvvvvvv0+"_ScrollChanged",(int) (1));
 //BA.debugLineNum = 51;BA.debugLine="ResetVisibles";
_vvvvvvvvvv0();
 //BA.debugLineNum = 52;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvv0(int _index,anywheresoftware.b4a.objects.B4XViewWrapper _pnl,Object _value) throws Exception{
float _size = 0f;
 //BA.debugLineNum = 205;BA.debugLine="Public Sub InsertAt(Index As Int, pnl As B4XView,";
 //BA.debugLineNum = 206;BA.debugLine="Dim size As Float";
_size = 0f;
 //BA.debugLineNum = 207;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 208;BA.debugLine="size = pnl.Width";
_size = (float) (_pnl.getWidth());
 }else {
 //BA.debugLineNum = 210;BA.debugLine="size = pnl.Height";
_size = (float) (_pnl.getHeight());
 };
 //BA.debugLineNum = 212;BA.debugLine="InsertAtImpl(Index, pnl, size, Value, 0)";
_vvvvvvvvvv1(_index,_pnl,(int) (_size),_value,(int) (0));
 //BA.debugLineNum = 213;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv1(int _index,anywheresoftware.b4a.objects.B4XViewWrapper _pnl,int _itemsize,Object _value,int _initialsize) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _includedividierheight = 0;
com.kobe.code.arthur.customlistview._clvitem _newitem = null;
int _offset = 0;
com.kobe.code.arthur.customlistview._clvitem _previtem = null;
int _i = 0;
com.kobe.code.arthur.customlistview._clvitem _it = null;
int _newoffset = 0;
 //BA.debugLineNum = 216;BA.debugLine="Private Sub InsertAtImpl(Index As Int, Pnl As B4XV";
 //BA.debugLineNum = 218;BA.debugLine="Dim p As B4XView = CreatePanel(\"Panel\")";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvv7("Panel");
 //BA.debugLineNum = 219;BA.debugLine="p.Color = Pnl.Color";
_p.setColor(_pnl.getColor());
 //BA.debugLineNum = 220;BA.debugLine="Pnl.Color = xui.Color_Transparent";
_pnl.setColor(_vvvvvvvvvvvvv7.Color_Transparent);
 //BA.debugLineNum = 221;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 222;BA.debugLine="p.AddView(Pnl, 0, 0, ItemSize, sv.ScrollViewCont";
_p.AddView((android.view.View)(_pnl.getObject()),(int) (0),(int) (0),_itemsize,_vvvvvvvvvvvv5.getScrollViewContentHeight());
 }else {
 //BA.debugLineNum = 224;BA.debugLine="p.AddView(Pnl, 0, 0, sv.ScrollViewContentWidth,";
_p.AddView((android.view.View)(_pnl.getObject()),(int) (0),(int) (0),_vvvvvvvvvvvv5.getScrollViewContentWidth(),_itemsize);
 };
 //BA.debugLineNum = 226;BA.debugLine="p.Tag = Index";
_p.setTag((Object)(_index));
 //BA.debugLineNum = 227;BA.debugLine="Dim IncludeDividierHeight As Int";
_includedividierheight = 0;
 //BA.debugLineNum = 228;BA.debugLine="If InitialSize = 0 Then IncludeDividierHeight = m";
if (_initialsize==0) { 
_includedividierheight = (int) (_vvvvvvvvvvvv7);}
else {
_includedividierheight = (int) (0);};
 //BA.debugLineNum = 229;BA.debugLine="Dim NewItem As CLVItem";
_newitem = new com.kobe.code.arthur.customlistview._clvitem();
 //BA.debugLineNum = 230;BA.debugLine="NewItem.Panel = p";
_newitem.Panel = _p;
 //BA.debugLineNum = 231;BA.debugLine="NewItem.Size = ItemSize";
_newitem.Size = _itemsize;
 //BA.debugLineNum = 232;BA.debugLine="NewItem.Value = Value";
_newitem.Value = _value;
 //BA.debugLineNum = 233;BA.debugLine="NewItem.Color = p.Color";
_newitem.Color = _p.getColor();
 //BA.debugLineNum = 234;BA.debugLine="If Index = items.Size And InitialSize = 0 Then";
if (_index==_vvvvvvvvvvvv6.getSize() && _initialsize==0) { 
 //BA.debugLineNum = 235;BA.debugLine="items.Add(NewItem)";
_vvvvvvvvvvvv6.Add((Object)(_newitem));
 //BA.debugLineNum = 236;BA.debugLine="Dim offset As Int";
_offset = 0;
 //BA.debugLineNum = 237;BA.debugLine="If Index = 0 Then";
if (_index==0) { 
 //BA.debugLineNum = 238;BA.debugLine="offset = mDividerSize";
_offset = (int) (_vvvvvvvvvvvv7);
 }else {
 //BA.debugLineNum = 240;BA.debugLine="offset = GetScrollViewContentSize";
_offset = (int) (_vvvvvvvvv3());
 };
 //BA.debugLineNum = 242;BA.debugLine="NewItem.Offset = offset";
_newitem.Offset = _offset;
 //BA.debugLineNum = 243;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 244;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, offset, 0, I";
_vvvvvvvvvvvv5.getScrollViewInnerPanel().AddView((android.view.View)(_p.getObject()),_offset,(int) (0),_itemsize,_vvvvvvvvvvvv5.getHeight());
 }else {
 //BA.debugLineNum = 246;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, 0, offset, s";
_vvvvvvvvvvvv5.getScrollViewInnerPanel().AddView((android.view.View)(_p.getObject()),(int) (0),_offset,_vvvvvvvvvvvv5.getWidth(),_itemsize);
 };
 }else {
 //BA.debugLineNum = 249;BA.debugLine="Dim offset As Int";
_offset = 0;
 //BA.debugLineNum = 250;BA.debugLine="If Index = 0 Then";
if (_index==0) { 
 //BA.debugLineNum = 251;BA.debugLine="offset = mDividerSize";
_offset = (int) (_vvvvvvvvvvvv7);
 }else {
 //BA.debugLineNum = 253;BA.debugLine="Dim PrevItem As CLVItem = items.Get(Index - 1)";
_previtem = (com.kobe.code.arthur.customlistview._clvitem)(_vvvvvvvvvvvv6.Get((int) (_index-1)));
 //BA.debugLineNum = 254;BA.debugLine="offset = PrevItem.Offset + PrevItem.Size + mDiv";
_offset = (int) (_previtem.Offset+_previtem.Size+_vvvvvvvvvvvv7);
 };
 //BA.debugLineNum = 256;BA.debugLine="For i = Index To items.Size - 1";
{
final int step39 = 1;
final int limit39 = (int) (_vvvvvvvvvvvv6.getSize()-1);
_i = _index ;
for (;_i <= limit39 ;_i = _i + step39 ) {
 //BA.debugLineNum = 257;BA.debugLine="Dim It As CLVItem = items.Get(i)";
_it = (com.kobe.code.arthur.customlistview._clvitem)(_vvvvvvvvvvvv6.Get(_i));
 //BA.debugLineNum = 258;BA.debugLine="Dim NewOffset As Int = It.Offset + ItemSize - I";
_newoffset = (int) (_it.Offset+_itemsize-_initialsize+_includedividierheight);
 //BA.debugLineNum = 259;BA.debugLine="If Min(NewOffset, It.Offset) - GetScrollViewOff";
if (__c.Min(_newoffset,_it.Offset)-_vvvvvvvvv4()<_vvvvvvvvv5()) { 
 //BA.debugLineNum = 260;BA.debugLine="It.Offset = NewOffset";
_it.Offset = _newoffset;
 //BA.debugLineNum = 261;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 262;BA.debugLine="It.Panel.SetLayoutAnimated(AnimationDuration,";
_it.Panel.SetLayoutAnimated(_vvvvvvvvvvvvv4,_newoffset,(int) (0),_it.Size,_it.Panel.getHeight());
 }else {
 //BA.debugLineNum = 264;BA.debugLine="It.Panel.SetLayoutAnimated(AnimationDuration,";
_it.Panel.SetLayoutAnimated(_vvvvvvvvvvvvv4,(int) (0),_newoffset,_it.Panel.getWidth(),_it.Size);
 };
 }else {
 //BA.debugLineNum = 267;BA.debugLine="SetItemOffset(It, NewOffset)";
_vvvvvvvvvvv4(_it,(float) (_newoffset));
 };
 //BA.debugLineNum = 269;BA.debugLine="It.Panel.Tag = i + 1";
_it.Panel.setTag((Object)(_i+1));
 }
};
 //BA.debugLineNum = 271;BA.debugLine="items.InsertAt(Index, NewItem)";
_vvvvvvvvvvvv6.InsertAt(_index,(Object)(_newitem));
 //BA.debugLineNum = 272;BA.debugLine="NewItem.Offset = offset";
_newitem.Offset = _offset;
 //BA.debugLineNum = 273;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 274;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, offset, 0, I";
_vvvvvvvvvvvv5.getScrollViewInnerPanel().AddView((android.view.View)(_p.getObject()),_offset,(int) (0),_initialsize,_vvvvvvvvvvvv5.getHeight());
 //BA.debugLineNum = 275;BA.debugLine="p.SetLayoutAnimated(AnimationDuration, offset,";
_p.SetLayoutAnimated(_vvvvvvvvvvvvv4,_offset,(int) (0),_itemsize,_p.getHeight());
 }else {
 //BA.debugLineNum = 277;BA.debugLine="sv.ScrollViewInnerPanel.AddView(p, 0, offset, s";
_vvvvvvvvvvvv5.getScrollViewInnerPanel().AddView((android.view.View)(_p.getObject()),(int) (0),_offset,_vvvvvvvvvvvv5.getWidth(),_initialsize);
 //BA.debugLineNum = 278;BA.debugLine="p.SetLayoutAnimated(AnimationDuration, 0, offse";
_p.SetLayoutAnimated(_vvvvvvvvvvvvv4,(int) (0),_offset,_p.getWidth(),_itemsize);
 };
 };
 //BA.debugLineNum = 281;BA.debugLine="SetScrollViewContentSize(GetScrollViewContentSize";
_vvvvvvvvvvv5((float) (_vvvvvvvvv3()+_itemsize-_initialsize+_includedividierheight));
 //BA.debugLineNum = 282;BA.debugLine="If items.Size = 1 Then SetScrollViewContentSize(G";
if (_vvvvvvvvvvvv6.getSize()==1) { 
_vvvvvvvvvvv5((float) (_vvvvvvvvv3()+_includedividierheight));};
 //BA.debugLineNum = 283;BA.debugLine="If Index < mLastVisibleIndex Or GetRawListItem(mL";
if (_index<_vvvvvvvvvvvvvv3 || _vvvvvvvvv2(_vvvvvvvvvvvvvv3).Offset+_vvvvvvvvv2(_vvvvvvvvvvvvvv3).Size+_vvvvvvvvvvvv7<_vvvvvvvvv5()) { 
 //BA.debugLineNum = 285;BA.debugLine="UpdateVisibleRange";
_vvvvvvvvvvv7();
 };
 //BA.debugLineNum = 287;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv2(int _index,Object _text,Object _value) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _pnl = null;
anywheresoftware.b4a.objects.B4XViewWrapper _lbl = null;
com.kobe.code.arthur.customlistview._clvitem _item = null;
 //BA.debugLineNum = 187;BA.debugLine="Public Sub InsertAtTextItem(Index As Int, Text As";
 //BA.debugLineNum = 188;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 189;BA.debugLine="Log(\"AddTextItem is only supported in vertical o";
__c.Log("AddTextItem is only supported in vertical orientation.");
 //BA.debugLineNum = 190;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 192;BA.debugLine="Dim pnl As B4XView = CreatePanel(\"\")";
_pnl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_pnl = _vvvvvvv7("");
 //BA.debugLineNum = 193;BA.debugLine="Dim lbl As B4XView = CreateLabel(Text)";
_lbl = new anywheresoftware.b4a.objects.B4XViewWrapper();
_lbl = _vvvvvvv6(_text);
 //BA.debugLineNum = 194;BA.debugLine="lbl.Height = Max(50dip, lbl.Height)";
_lbl.setHeight((int) (__c.Max(__c.DipToCurrent((int) (50)),_lbl.getHeight())));
 //BA.debugLineNum = 195;BA.debugLine="pnl.AddView(lbl, 5dip, 2dip, sv.ScrollViewContent";
_pnl.AddView((android.view.View)(_lbl.getObject()),__c.DipToCurrent((int) (5)),__c.DipToCurrent((int) (2)),(int) (_vvvvvvvvvvvv5.getScrollViewContentWidth()-__c.DipToCurrent((int) (10))),_lbl.getHeight());
 //BA.debugLineNum = 196;BA.debugLine="lbl.TextColor = DefaultTextColor";
_lbl.setTextColor(_vvvvvvvvvvvvv2);
 //BA.debugLineNum = 197;BA.debugLine="pnl.Color = DefaultTextBackgroundColor";
_pnl.setColor(_vvvvvvvvvvvvv3);
 //BA.debugLineNum = 198;BA.debugLine="pnl.Height = lbl.Height + 2dip";
_pnl.setHeight((int) (_lbl.getHeight()+__c.DipToCurrent((int) (2))));
 //BA.debugLineNum = 199;BA.debugLine="InsertAt(Index, pnl, Value)";
_vvvvvvvvv0(_index,_pnl,_value);
 //BA.debugLineNum = 200;BA.debugLine="Dim item As CLVItem = GetRawListItem(Index)";
_item = _vvvvvvvvv2(_index);
 //BA.debugLineNum = 201;BA.debugLine="item.TextItem = True";
_item.TextItem = __c.True;
 //BA.debugLineNum = 202;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv3(int _index) throws Exception{
 //BA.debugLineNum = 376;BA.debugLine="Public Sub JumpToItem(Index As Int)";
 //BA.debugLineNum = 377;BA.debugLine="SetScrollViewOffset(Min(GetMaxScrollOffset, FindI";
_vvvvvvvvvvv6((float) (__c.Min(_vvvvvvvv0(),_vvvvvvvv2(_index))));
 //BA.debugLineNum = 378;BA.debugLine="End Sub";
return "";
}
public String  _panel_click() throws Exception{
 //BA.debugLineNum = 516;BA.debugLine="Private Sub Panel_Click";
 //BA.debugLineNum = 517;BA.debugLine="PanelClickHandler(Sender)";
_vvvvvvvvvv4((anywheresoftware.b4a.objects.B4XViewWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.B4XViewWrapper(), (java.lang.Object)(__c.Sender(ba))));
 //BA.debugLineNum = 518;BA.debugLine="End Sub";
return "";
}
public void  _vvvvvvvvvv4(anywheresoftware.b4a.objects.B4XViewWrapper _senderpanel) throws Exception{
ResumableSub_PanelClickHandler rsub = new ResumableSub_PanelClickHandler(this,_senderpanel);
rsub.resume(ba, null);
}
public static class ResumableSub_PanelClickHandler extends BA.ResumableSub {
public ResumableSub_PanelClickHandler(com.kobe.code.arthur.customlistview parent,anywheresoftware.b4a.objects.B4XViewWrapper _senderpanel) {
this.parent = parent;
this._senderpanel = _senderpanel;
}
com.kobe.code.arthur.customlistview parent;
anywheresoftware.b4a.objects.B4XViewWrapper _senderpanel;
int _clr = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 //BA.debugLineNum = 454;BA.debugLine="Dim clr As Int = GetRawListItem(SenderPanel.Tag).";
_clr = parent._vvvvvvvvv2((int)(BA.ObjectToNumber(_senderpanel.getTag()))).Color;
 //BA.debugLineNum = 455;BA.debugLine="SenderPanel.SetColorAnimated(50, clr, PressedColo";
_senderpanel.SetColorAnimated((int) (50),_clr,parent._vvvvvvvvvvvvv6);
 //BA.debugLineNum = 456;BA.debugLine="If xui.SubExists(CallBack, EventName & \"_ItemClic";
if (true) break;

case 1:
//if
this.state = 4;
if (parent._vvvvvvvvvvvvv7.SubExists(ba,parent._vvvvvvvvvvvvv1,parent._vvvvvvvvvvvv0+"_ItemClick",(int) (2))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 //BA.debugLineNum = 457;BA.debugLine="CallSub3(CallBack, EventName & \"_ItemClick\", Sen";
parent.__c.CallSubNew3(ba,parent._vvvvvvvvvvvvv1,parent._vvvvvvvvvvvv0+"_ItemClick",_senderpanel.getTag(),parent._vvvvvvvvv2((int)(BA.ObjectToNumber(_senderpanel.getTag()))).Value);
 if (true) break;

case 4:
//C
this.state = -1;
;
 //BA.debugLineNum = 459;BA.debugLine="Sleep(200)";
parent.__c.Sleep(ba,this,(int) (200));
this.state = 5;
return;
case 5:
//C
this.state = -1;
;
 //BA.debugLineNum = 460;BA.debugLine="SenderPanel.SetColorAnimated(200, PressedColor, c";
_senderpanel.SetColorAnimated((int) (200),parent._vvvvvvvvvvvvv6,_clr);
 //BA.debugLineNum = 461;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _vvvvvvvvvv5() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Public Sub Refresh";
 //BA.debugLineNum = 61;BA.debugLine="ResetVisibles";
_vvvvvvvvvv0();
 //BA.debugLineNum = 62;BA.debugLine="UpdateVisibleRange";
_vvvvvvvvvvv7();
 //BA.debugLineNum = 63;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv6(int _index) throws Exception{
com.kobe.code.arthur.customlistview._clvitem _removeitem = null;
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
int _i = 0;
com.kobe.code.arthur.customlistview._clvitem _item = null;
int _newoffset = 0;
 //BA.debugLineNum = 161;BA.debugLine="Public Sub RemoveAt(Index As Int)";
 //BA.debugLineNum = 162;BA.debugLine="If getSize <= 1 Then";
if (_getvvvvvvvvvvvv3()<=1) { 
 //BA.debugLineNum = 163;BA.debugLine="Clear";
_vvvvvvv5();
 //BA.debugLineNum = 164;BA.debugLine="Return";
if (true) return "";
 };
 //BA.debugLineNum = 166;BA.debugLine="Dim RemoveItem As CLVItem = items.Get(Index)";
_removeitem = (com.kobe.code.arthur.customlistview._clvitem)(_vvvvvvvvvvvv6.Get(_index));
 //BA.debugLineNum = 167;BA.debugLine="Dim p As B4XView";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
 //BA.debugLineNum = 168;BA.debugLine="For i = Index + 1 To items.Size - 1";
{
final int step7 = 1;
final int limit7 = (int) (_vvvvvvvvvvvv6.getSize()-1);
_i = (int) (_index+1) ;
for (;_i <= limit7 ;_i = _i + step7 ) {
 //BA.debugLineNum = 169;BA.debugLine="Dim item As CLVItem = items.Get(i)";
_item = (com.kobe.code.arthur.customlistview._clvitem)(_vvvvvvvvvvvv6.Get(_i));
 //BA.debugLineNum = 170;BA.debugLine="p = item.Panel";
_p = _item.Panel;
 //BA.debugLineNum = 171;BA.debugLine="p.Tag = i - 1";
_p.setTag((Object)(_i-1));
 //BA.debugLineNum = 172;BA.debugLine="Dim NewOffset As Int = item.Offset - RemoveItem.";
_newoffset = (int) (_item.Offset-_removeitem.Size-_vvvvvvvvvvvv7);
 //BA.debugLineNum = 173;BA.debugLine="SetItemOffset(item, NewOffset)";
_vvvvvvvvvvv4(_item,(float) (_newoffset));
 }
};
 //BA.debugLineNum = 175;BA.debugLine="SetScrollViewContentSize(GetScrollViewContentSize";
_vvvvvvvvvvv5((float) (_vvvvvvvvv3()-_removeitem.Size-_vvvvvvvvvvvv7));
 //BA.debugLineNum = 176;BA.debugLine="items.RemoveAt(Index)";
_vvvvvvvvvvvv6.RemoveAt(_index);
 //BA.debugLineNum = 177;BA.debugLine="RemoveItem.Panel.RemoveViewFromParent";
_removeitem.Panel.RemoveViewFromParent();
 //BA.debugLineNum = 178;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv7(int _index,anywheresoftware.b4a.objects.B4XViewWrapper _pnl,int _itemheight,Object _value) throws Exception{
com.kobe.code.arthur.customlistview._clvitem _removeitem = null;
 //BA.debugLineNum = 361;BA.debugLine="Public Sub ReplaceAt(Index As Int, pnl As B4XView,";
 //BA.debugLineNum = 362;BA.debugLine="Dim RemoveItem As CLVItem = items.Get(Index)";
_removeitem = (com.kobe.code.arthur.customlistview._clvitem)(_vvvvvvvvvvvv6.Get(_index));
 //BA.debugLineNum = 363;BA.debugLine="items.RemoveAt(Index)";
_vvvvvvvvvvvv6.RemoveAt(_index);
 //BA.debugLineNum = 364;BA.debugLine="RemoveItem.Panel.RemoveViewFromParent";
_removeitem.Panel.RemoveViewFromParent();
 //BA.debugLineNum = 365;BA.debugLine="InsertAtImpl(Index, pnl, ItemHeight, Value, Remov";
_vvvvvvvvvv1(_index,_pnl,_itemheight,_value,_removeitem.Size);
 //BA.debugLineNum = 366;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvv0() throws Exception{
 //BA.debugLineNum = 54;BA.debugLine="Private Sub ResetVisibles";
 //BA.debugLineNum = 55;BA.debugLine="mFirstVisibleIndex = -1";
_vvvvvvvvvvvvvv2 = (int) (-1);
 //BA.debugLineNum = 56;BA.debugLine="mLastVisibleIndex = 0x7FFFFFFF";
_vvvvvvvvvvvvvv3 = (int) (0x7fffffff);
 //BA.debugLineNum = 57;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv1(int _index,int _itemheight) throws Exception{
anywheresoftware.b4a.objects.B4XViewWrapper _p = null;
Object _value = null;
anywheresoftware.b4a.objects.B4XViewWrapper _parent = null;
 //BA.debugLineNum = 350;BA.debugLine="Public Sub ResizeItem(Index As Int, ItemHeight As";
 //BA.debugLineNum = 351;BA.debugLine="Dim p As B4XView = GetPanel(Index)";
_p = new anywheresoftware.b4a.objects.B4XViewWrapper();
_p = _vvvvvvvvv1(_index);
 //BA.debugLineNum = 352;BA.debugLine="Dim value As Object = GetValue(Index)";
_value = _vvvvvvvvv7(_index);
 //BA.debugLineNum = 353;BA.debugLine="Dim parent As B4XView = p.Parent";
_parent = new anywheresoftware.b4a.objects.B4XViewWrapper();
_parent = _p.getParent();
 //BA.debugLineNum = 354;BA.debugLine="p.Color = parent.Color";
_p.setColor(_parent.getColor());
 //BA.debugLineNum = 355;BA.debugLine="p.RemoveViewFromParent";
_p.RemoveViewFromParent();
 //BA.debugLineNum = 356;BA.debugLine="ReplaceAt(Index, p, ItemHeight, value)";
_vvvvvvvvvv7(_index,_p,_itemheight,_value);
 //BA.debugLineNum = 357;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv2() throws Exception{
int _position = 0;
 //BA.debugLineNum = 474;BA.debugLine="Private Sub ScrollHandler";
 //BA.debugLineNum = 475;BA.debugLine="If items.Size = 0 Then Return";
if (_vvvvvvvvvvvv6.getSize()==0) { 
if (true) return "";};
 //BA.debugLineNum = 476;BA.debugLine="Dim position As Int = GetScrollViewOffset";
_position = (int) (_vvvvvvvvv4());
 //BA.debugLineNum = 477;BA.debugLine="If position + GetScrollViewVisibleSize >= GetScro";
if (_position+_vvvvvvvvv5()>=_vvvvvvvvv3()-__c.DipToCurrent((int) (5)) && __c.DateTime.getNow()>_vvvvvvvvvvvvv5+100) { 
 //BA.debugLineNum = 478;BA.debugLine="If xui.SubExists(CallBack, EventName & \"_ReachEn";
if (_vvvvvvvvvvvvv7.SubExists(ba,_vvvvvvvvvvvvv1,_vvvvvvvvvvvv0+"_ReachEnd",(int) (0))) { 
 //BA.debugLineNum = 479;BA.debugLine="LastReachEndEvent = DateTime.Now";
_vvvvvvvvvvvvv5 = __c.DateTime.getNow();
 //BA.debugLineNum = 480;BA.debugLine="CallSubDelayed(CallBack, EventName & \"_ReachEnd";
__c.CallSubDelayed(ba,_vvvvvvvvvvvvv1,_vvvvvvvvvvvv0+"_ReachEnd");
 }else {
 //BA.debugLineNum = 482;BA.debugLine="LastReachEndEvent = DateTime.Now + 1000 * DateT";
_vvvvvvvvvvvvv5 = (long) (__c.DateTime.getNow()+1000*__c.DateTime.TicksPerDay);
 };
 };
 //BA.debugLineNum = 485;BA.debugLine="UpdateVisibleRange";
_vvvvvvvvvvv7();
 //BA.debugLineNum = 486;BA.debugLine="If FireScrollChanged Then";
if (_vvvvvvvvvvvvvv5) { 
 //BA.debugLineNum = 487;BA.debugLine="CallSub2(CallBack, EventName & \"_ScrollChanged\",";
__c.CallSubNew2(ba,_vvvvvvvvvvvvv1,_vvvvvvvvvvvv0+"_ScrollChanged",(Object)(_position));
 };
 //BA.debugLineNum = 489;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv3(int _index) throws Exception{
float _offset = 0f;
anywheresoftware.b4a.objects.HorizontalScrollViewWrapper _hv = null;
anywheresoftware.b4a.objects.ScrollViewWrapper _nsv = null;
 //BA.debugLineNum = 385;BA.debugLine="Public Sub ScrollToItem(Index As Int)";
 //BA.debugLineNum = 386;BA.debugLine="Dim offset As Float = Min(GetMaxScrollOffset, Fin";
_offset = (float) (__c.Min(_vvvvvvvv0(),_vvvvvvvv2(_index)));
 //BA.debugLineNum = 398;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 399;BA.debugLine="Dim hv As HorizontalScrollView = sv";
_hv = new anywheresoftware.b4a.objects.HorizontalScrollViewWrapper();
_hv.setObject((android.widget.HorizontalScrollView)(_vvvvvvvvvvvv5.getObject()));
 //BA.debugLineNum = 400;BA.debugLine="hv.ScrollPosition = offset 'smooth scroll";
_hv.setScrollPosition((int) (_offset));
 }else {
 //BA.debugLineNum = 402;BA.debugLine="Dim nsv As ScrollView = sv";
_nsv = new anywheresoftware.b4a.objects.ScrollViewWrapper();
_nsv.setObject((android.widget.ScrollView)(_vvvvvvvvvvvv5.getObject()));
 //BA.debugLineNum = 403;BA.debugLine="nsv.ScrollPosition = offset";
_nsv.setScrollPosition((int) (_offset));
 };
 //BA.debugLineNum = 406;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv4(com.kobe.code.arthur.customlistview._clvitem _item,float _offset) throws Exception{
 //BA.debugLineNum = 340;BA.debugLine="Private Sub SetItemOffset (item As CLVItem, offset";
 //BA.debugLineNum = 341;BA.debugLine="item.Offset = offset";
_item.Offset = (int) (_offset);
 //BA.debugLineNum = 342;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 343;BA.debugLine="item.Panel.Left = offset";
_item.Panel.setLeft((int) (_offset));
 }else {
 //BA.debugLineNum = 345;BA.debugLine="item.Panel.Top = offset";
_item.Panel.setTop((int) (_offset));
 };
 //BA.debugLineNum = 347;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv5(float _f) throws Exception{
 //BA.debugLineNum = 332;BA.debugLine="Private Sub SetScrollViewContentSize(f As Float)";
 //BA.debugLineNum = 333;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 334;BA.debugLine="sv.ScrollViewContentWidth = f";
_vvvvvvvvvvvv5.setScrollViewContentWidth((int) (_f));
 }else {
 //BA.debugLineNum = 336;BA.debugLine="sv.ScrollViewContentHeight = f";
_vvvvvvvvvvvv5.setScrollViewContentHeight((int) (_f));
 };
 //BA.debugLineNum = 338;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv6(float _offset) throws Exception{
 //BA.debugLineNum = 316;BA.debugLine="Private Sub SetScrollViewOffset(offset As Float)";
 //BA.debugLineNum = 317;BA.debugLine="If horizontal Then";
if (_vvvvvvvvvvvvvv1) { 
 //BA.debugLineNum = 318;BA.debugLine="sv.ScrollViewOffsetX = offset";
_vvvvvvvvvvvv5.setScrollViewOffsetX((int) (_offset));
 }else {
 //BA.debugLineNum = 320;BA.debugLine="sv.ScrollViewOffsetY = offset";
_vvvvvvvvvvvv5.setScrollViewOffsetY((int) (_offset));
 };
 //BA.debugLineNum = 322;BA.debugLine="End Sub";
return "";
}
public String  _sv_scrollchanged(int _position) throws Exception{
 //BA.debugLineNum = 520;BA.debugLine="Private Sub sv_ScrollChanged(Position As Int)";
 //BA.debugLineNum = 521;BA.debugLine="ScrollHandler";
_vvvvvvvvvvv2();
 //BA.debugLineNum = 522;BA.debugLine="End Sub";
return "";
}
public String  _vvvvvvvvvvv7() throws Exception{
int _first = 0;
int _last = 0;
 //BA.debugLineNum = 289;BA.debugLine="Private Sub UpdateVisibleRange";
 //BA.debugLineNum = 290;BA.debugLine="If MonitorVisibleRange = False Or getSize = 0 The";
if (_vvvvvvvvvvvvvv4==__c.False || _getvvvvvvvvvvvv3()==0) { 
if (true) return "";};
 //BA.debugLineNum = 291;BA.debugLine="Dim first As Int = getFirstVisibleIndex";
_first = _getvvvvvvvvvvvv1();
 //BA.debugLineNum = 292;BA.debugLine="Dim last As Int = getLastVisibleIndex";
_last = _getvvvvvvvvvvvv2();
 //BA.debugLineNum = 293;BA.debugLine="If first <> mFirstVisibleIndex Or last <> mLastVi";
if (_first!=_vvvvvvvvvvvvvv2 || _last!=_vvvvvvvvvvvvvv3) { 
 //BA.debugLineNum = 294;BA.debugLine="mFirstVisibleIndex = first";
_vvvvvvvvvvvvvv2 = _first;
 //BA.debugLineNum = 295;BA.debugLine="mLastVisibleIndex = last";
_vvvvvvvvvvvvvv3 = _last;
 //BA.debugLineNum = 296;BA.debugLine="CallSubDelayed3(CallBack, EventName & \"_VisibleR";
__c.CallSubDelayed3(ba,_vvvvvvvvvvvvv1,_vvvvvvvvvvvv0+"_VisibleRangeChanged",(Object)(_vvvvvvvvvvvvvv2),(Object)(_vvvvvvvvvvvvvv3));
 };
 //BA.debugLineNum = 298;BA.debugLine="End Sub";
return "";
}
public Object callSub(String sub, Object sender, Object[] args) throws Exception {
BA.senderHolder.set(sender);
return BA.SubDelegator.SubNotFound;
}
}
