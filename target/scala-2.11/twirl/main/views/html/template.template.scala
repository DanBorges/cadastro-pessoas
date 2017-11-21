
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object template extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="pt-BR" ng-app="moduleTemplate" ng-controller="controllerTemplate">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="icon" href='/assets/images/favicon.ico'>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="CIMTech">

	<title>Cadastro Pessoas</title>

	<link rel="stylesheet" href="assets/stylesheets/css/main.css">
	
	<link rel="stylesheet" media="screen" href='"""),_display_(/*14.47*/routes/*14.53*/.Assets.at("/stylesheets/vendor/bootstrap.css")),format.raw/*14.100*/("""'>
	<link rel="stylesheet" href='"""),_display_(/*15.32*/routes/*15.38*/.Assets.at("/stylesheets/vendor/font-awesome.min.css")),format.raw/*15.92*/("""'>
	
	
	<style>
	.template-alerta """),format.raw/*19.19*/("""{"""),format.raw/*19.20*/("""
	    """),format.raw/*20.6*/("""position: fixed;
	    z-index: 9999999;
	    padding: 20px;
	    border-radius: 5px 5px 5px 5px;
	    margin: -1.4em auto;
	    width: 60%;
	    text-align: center;
	    margin-left: 20%;
	"""),format.raw/*28.2*/("""}"""),format.raw/*28.3*/("""
	"""),format.raw/*29.2*/("""</style>

</head>

<body>

   	<section>
		<div id="divMain wrapper">
		<div class="template-alerta">
		   	<div directive-alerta-sistema-template></div>
		</div>
			<div ng-view></div>
		</div>
	</section>

	<section class="footer">
		<footer>
			<div class="row">
				<div class="col-md-12">
					<hr />
					<h6 style="text-align: center; color: #000;">&copy; 
						2017 - Daniel Lemes Borges.</h6>
				</div>
			</div>
		</footer>
	</section>

	<!-- angular -->
	<script src="assets/javascripts/vendor/angular.js"></script>
	<script src="assets/javascripts/vendor/angular-route.min.js"></script>
	<script src="assets/javascripts/vendor/angular-cookies.min.js"></script>
	<script src="/assets/javascripts/vendor/angular-translate.js"></script>
	<script src="assets/javascripts/vendor/angular-md5.js"></script>
	<script src="/assets/javascripts/vendor/i18n/angular-locale_pt-br.js"></script>

	<!-- jquery -->
	<script src="assets/javascripts/vendor/jquery-1.11.3.min.js"></script>

	<!-- jquery ui -->
	<script src="assets/javascripts/vendor/jquery-ui.min.js"></script>

	<!-- ui bootstrap -->
	<script src="assets/javascripts/vendor/ui-bootstrap-tpls-0.13.3.min.js"></script>
	<script src="assets/javascripts/vendor/bootstrap.min.js"></script>

	<!-- moment -->
	<script src="assets/javascripts/vendor/moment.min.js"></script>

	<!-- blockUI -->
	<script src="assets/javascripts/vendor/jquery.blockUI.min.js"></script>

	<!-- smart table -->
	<script type="text/javascript" src="assets/javascripts/vendor/smart-table.min.js"></script>



	<!-- Controllers -->
	<script src="assets/controller/templateController.js"></script>
	<script src="assets/controller/indexController.js"></script>


</body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Nov 21 15:07:02 BRST 2017
                  SOURCE: /home/daniel/eclipse-workspace/cadastro-pessoas/app/views/template.scala.html
                  HASH: 89f8b2e0ed8e75cb3d7cbae31a4f558a581ebafb
                  MATRIX: 801->0|1319->491|1334->497|1403->544|1464->578|1479->584|1554->638|1616->672|1645->673|1678->679|1894->868|1922->869|1951->871
                  LINES: 29->1|42->14|42->14|42->14|43->15|43->15|43->15|47->19|47->19|48->20|56->28|56->28|57->29
                  -- GENERATED --
              */
          