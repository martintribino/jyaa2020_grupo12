(window.webpackJsonp=window.webpackJsonp||[]).push([[18],{ARp9:function(t,a,i){"use strict";i.r(a),i.d(a,"ArtistaModule",(function(){return C}));var e=i("ofXK"),s=i("Wp6s"),n=i("f0Cb"),r=i("NFeN"),o=i("0IaG"),c=i("bTqV"),l=i("dNgK"),b=i("Qu3c"),u=i("Xa2L"),d=i("tyNb"),h=i("2Vo4"),g=i("qR9t"),m=i("wimQ"),p=i("MCLT"),f=i("nVpM"),S=i("fXoL"),v=i("lGQG"),T=i("gOGa"),k=i("/1K/"),j=i("ytFt"),A=i("m1IW");function w(t,a){1&t&&S.Ob(0,"div")}function I(t,a){1&t&&S.Ob(0,"div")}function q(t,a){if(1&t){const t=S.Ub();S.Tb(0,"button",12),S.ac("click",(function(){return S.rc(t),S.ec(2).onAddPhoto()})),S.Tb(1,"mat-icon"),S.zc(2,"add_a_photo"),S.Sb(),S.Sb(),S.Tb(3,"button",13),S.ac("click",(function(){return S.rc(t),S.ec(2).onEdit()})),S.Tb(4,"mat-icon"),S.zc(5,"edit"),S.Sb(),S.Sb(),S.Tb(6,"button",14),S.ac("click",(function(){return S.rc(t),S.ec(2).onDelete()})),S.Tb(7,"mat-icon"),S.zc(8,"delete"),S.Sb(),S.Sb()}if(2&t){const t=S.ec(2);S.kc("disabled",t.loading),S.Bb(3),S.kc("disabled",t.loading),S.Bb(3),S.kc("disabled",t.loading)}}const y=function(){return["/artistas/"]};function O(t,a){if(1&t){const t=S.Ub();S.Tb(0,"mat-card",3),S.Tb(1,"div",4),S.Ob(2,"img",5),S.Sb(),S.Tb(3,"mat-card-header"),S.Tb(4,"mat-card-title"),S.zc(5),S.fc(6,"async"),S.Sb(),S.Sb(),S.Tb(7,"mat-card-content"),S.Tb(8,"div",6),S.Tb(9,"strong"),S.zc(10,"Nombre"),S.Sb(),S.Tb(11,"span"),S.zc(12),S.fc(13,"async"),S.Sb(),S.Sb(),S.Ob(14,"mat-divider"),S.Tb(15,"div",6),S.Tb(16,"strong"),S.zc(17,"Apellido"),S.Sb(),S.Tb(18,"span"),S.zc(19),S.fc(20,"async"),S.Sb(),S.Sb(),S.Ob(21,"mat-divider"),S.Ob(22,"app-carrusel-imagenes",7),S.fc(23,"async"),S.Tb(24,"app-etiquetas-entidad",8),S.ac("agregar",(function(a){return S.rc(t),S.ec().agregarEtiqueta(a)}))("eliminar",(function(a){return S.rc(t),S.ec().eliminarEtiqueta(a)})),S.fc(25,"async"),S.Sb(),S.Sb(),S.Tb(26,"mat-card-actions"),S.Tb(27,"button",9),S.Tb(28,"mat-icon"),S.zc(29,"arrow_back_ios"),S.Sb(),S.Sb(),S.xc(30,I,1,0,"div",10),S.xc(31,q,9,3,"ng-template",null,11,S.yc),S.Sb(),S.Sb()}if(2&t){const t=S.oc(32),a=S.ec();var i,e,s,n;const o=null==(n=S.gc(23,16,a.artista))?null:n.fotos;var r;const c=null==(r=S.gc(25,18,a.artista))?null:r.etiquetas;S.Bb(2),S.kc("src",a.imgPath,S.sc),S.Bb(3),S.Ac(null==(i=S.gc(6,10,a.artista))?null:i.apodo),S.Bb(7),S.Ac(null==(e=S.gc(13,12,a.artista))?null:e.nombre),S.Bb(7),S.Ac(null==(s=S.gc(20,14,a.artista))?null:s.apellido),S.Bb(3),S.kc("slides",o),S.Bb(2),S.kc("etiquetas",c)("loading",a.loading),S.Bb(3),S.kc("routerLink",S.lc(20,y)),S.Bb(3),S.kc("ngIf",a.isAdmin())("ngIfThen",t)}}function N(t,a){1&t&&S.Ob(0,"mat-spinner")}function x(t,a){1&t&&(S.Tb(0,"h5"),S.zc(1,"No se pudo cargar el artista."),S.Sb())}function B(t,a){if(1&t&&(S.xc(0,N,1,0,"mat-spinner",15),S.xc(1,x,2,0,"h5",15)),2&t){const t=S.ec();S.kc("ngIf",t.loading),S.Bb(1),S.kc("ngIf",!t.loading)}}const z=[{path:"",component:(()=>{class t{constructor(t,a,i,e,s,n,r){this.authService=t,this.artistaServ=a,this.archivoServ=i,this.snackBar=e,this.dialog=s,this.router=n,this.route=r,this.artistaSubject=new h.a(null),this.artista=this.artistaSubject.asObservable(),this.loading=!1,this.id=null,this.imgPath="assets/images/user.png",this.route.params.subscribe(t=>{this.id=parseInt(t.id)})}ngOnInit(){this.loading=!0,this.artistaServ.getArtista(this.id).subscribe(t=>this.onSuccess(t),t=>this.onError(t),()=>this.loading=!1)}onSuccess(t){this.artistaSubject.next(t),this.loading=!1}onError(t){this.artistaSubject.next(null),this.loading=!1}getFotos(){let t=this.artistaSubject.value;return null!=t&&Object(p.isArray)(t.fotos)?t.fotos:[]}onAddPhoto(){let t=this.artistaSubject.value;null!=t&&this.dialog.open(f.a,{maxWidth:"550px",maxHeight:"100%",height:"auto",data:{action:g.a.crear,path:"artista",data:t}}).afterClosed().subscribe(t=>{this.ngOnInit()})}onEdit(){let t=this.artistaSubject.value;null!=t&&this.dialog.open(m.a,{maxWidth:"550px",maxHeight:"100%",height:"auto",data:{action:g.a.editar,data:t}}).afterClosed().subscribe(t=>{let a=t;null!=a&&this.artistaServ.actualizarArtista(a).subscribe(()=>{this.mostrarMensaje("Se ha editado correctamente el artista "+a.nombre,"success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido actualizar el artista "+a.nombre,"error")})})}onDelete(){let t=this.artistaSubject.value;null!=t&&(this.loading=!0,this.artistaServ.eliminarArtista(t).subscribe(()=>{this.mostrarMensaje("Se ha dado de baja correctamente al artista "+t.nombre,"success"),this.router.navigate(["/artistas"])},()=>{this.mostrarMensaje("No se ha podido dar de baja el artista "+t.nombre,"error"),this.loading=!1},()=>{this.loading=!1}))}agregarEtiqueta(t){let a=this.artistaSubject.value;if(null!=a){let i=[...a.etiquetas];a.etiquetas.push({id:null,nombre:t}),this.loading=!0,this.artistaServ.actualizarArtista(a).subscribe(()=>{this.mostrarMensaje("Se ha agregado la etiqueta "+t,"success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido agregar la etiqueta "+t,"error"),a.etiquetas=i,this.loading=!1},()=>{this.loading=!1})}}eliminarEtiqueta(t){let a=this.artistaSubject.value;null!=a&&(a.etiquetas=a.etiquetas.filter(a=>a.id!=t.id),this.loading=!0,this.artistaServ.actualizarArtista(a).subscribe(()=>{this.mostrarMensaje("Se ha eliminado la etiqueta","success"),this.ngOnInit()},()=>{this.mostrarMensaje("No se ha podido eliminar la etiqueta","error"),this.loading=!1},()=>{this.loading=!1}))}mostrarMensaje(t,a="",i=g.c,e="bottom"){this.snackBar.open(t,"",{duration:i,verticalPosition:e,panelClass:a})}isAdmin(){let t=this.authService.getUsuario();return null!=t&&t.rol==g.d.Administrador}}return t.\u0275fac=function(a){return new(a||t)(S.Nb(v.a),S.Nb(T.a),S.Nb(k.a),S.Nb(l.a),S.Nb(o.b),S.Nb(d.b),S.Nb(d.a))},t.\u0275cmp=S.Hb({type:t,selectors:[["app-artista"]],decls:6,vars:5,consts:[[4,"ngIf","ngIfThen","ngIfElse"],["ifBlock",""],["elseBlock",""],[1,"default-card"],[1,"avatar-upload"],["mat-card-image","","alt","Foto de artista",1,"default-avatar",3,"src"],[1,"card-row"],[3,"slides"],[3,"etiquetas","loading","agregar","eliminar"],["mat-icon-button","","matTooltip","Volver","matTooltipPosition","below","aria-label","Volver",1,"row-profile-button",3,"routerLink"],[4,"ngIf","ngIfThen"],["ifAdminBlock",""],["mat-icon-button","","matTooltip","Agregar Fotos","matTooltipPosition","below","aria-label","Agregar Fotos",1,"row-profile-button",3,"disabled","click"],["mat-icon-button","","matTooltip","Editar Artista","matTooltipPosition","below","aria-label","Editar Artista",1,"row-profile-button",3,"disabled","click"],["mat-icon-button","","matTooltip","Eliminar Artista","matTooltipPosition","below","aria-label","Eliminar Artista",1,"row-profile-button",3,"disabled","click"],[4,"ngIf"]],template:function(t,a){if(1&t&&(S.xc(0,w,1,0,"div",0),S.fc(1,"async"),S.xc(2,O,33,21,"ng-template",null,1,S.yc),S.xc(4,B,2,2,"ng-template",null,2,S.yc)),2&t){const t=S.oc(3),i=S.oc(5);S.kc("ngIf",null!=S.gc(1,3,a.artista))("ngIfThen",t)("ngIfElse",i)}},directives:[e.n,s.a,s.e,s.d,s.h,s.c,n.a,j.a,A.a,s.b,c.a,b.a,d.c,r.a,u.b],pipes:[e.b],styles:[".mat-progress-spinner[_ngcontent-%COMP%]{margin-top:2em}app-carrusel-imagenes[_ngcontent-%COMP%]{margin-top:10px}"]}),t})()}];let E=(()=>{class t{}return t.\u0275mod=S.Lb({type:t}),t.\u0275inj=S.Kb({factory:function(a){return new(a||t)},imports:[[d.f.forChild(z)],d.f]}),t})();var M=i("ugYk"),P=i("zOQo");let C=(()=>{class t{}return t.\u0275mod=S.Lb({type:t}),t.\u0275inj=S.Kb({factory:function(a){return new(a||t)},providers:[],imports:[[E,M.a,P.a,e.c,s.f,n.b,r.b,c.b,o.f,b.b,l.b,u.a]]}),t})()}}]);