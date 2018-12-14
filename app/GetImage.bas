B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=8.5
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
#End Region

Sub Process_Globals
	Private cacheAtivado As Boolean = True
	Private rp As RuntimePermissions
End Sub

Sub Service_Create
End Sub

Sub Service_Start (StartingIntent As Intent)
	Service.StopAutomaticForeground 
End Sub

Sub Service_Destroy
End Sub

Sub Baixa_Imagem (iv As ImageView, url As String)
	If cacheAtivado Then 'SE O CACHE ESTIVER ATIVADO VERIFICAMOS SE JÁ TEMOS A IMAGEM
		If File.Exists(rp.GetSafeDirDefaultExternal("cache"), PegaNome_Arquivo(url)) Then 'SE TIVER A IMAGEM CARREGA ELA E RETORNA, SE NÃO CONTINUA NORMALMENTE
			iv.SetBackgroundImage(LoadBitmapResize(rp.GetSafeDirDefaultExternal("cache"), PegaNome_Arquivo(url), iv.Width, iv.Height, True)).Gravity = Gravity.CENTER
			Return
		End If 
	End If
	Dim j As HttpJob
	j.Initialize("", Me)
	j.Download(url)
	j.GetRequest.Timeout = 10000 'TIME OUT DE NO MÁXIMO 10 SEGUNDOS PARA CADA IMAGEM
	Wait For (j) JobDone(j As HttpJob)
	If j.Success Then
		Try
			Dim out As OutputStream = File.OpenOutput(rp.GetSafeDirDefaultExternal("cache"), PegaNome_Arquivo(url) , False)
			File.Copy2(j.GetInputStream, out)
			out.Close 'IMPORTANTE FECHAR O OutputStream
		Catch
			Log("erro ao salvar a imagem "&PegaNome_Arquivo(url)&" em cache!")
		End Try
		If iv.IsInitialized Then iv.SetBackgroundImage(j.GetBitmap.Resize(iv.Width,iv.Height,True)).Gravity = Gravity.CENTER 'CARREGA A IMAGEM NA IMAGEVIEW
	Else
		If iv.IsInitialized Then iv.SetBackgroundImage(LoadBitmapResize(File.DirAssets,"semImagem.png", iv.Width, iv.Height, True)).Gravity = Gravity.CENTER 'SE NÃO CONSEGUIR BAIXAR, MOSTRA UMA IMAGEM PADRÃO
	End If
	j.Release
End Sub


Sub PegaNome_Arquivo(caminho As String) As String
	Return caminho.SubString(caminho.LastIndexOf("/") + 1)
End Sub