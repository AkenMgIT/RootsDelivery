<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="css/theme.css" rel="stylesheet">
        <link type="text/css" href="images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='https://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600' rel='stylesheet'>
<title>Fiche Client</title>
</head>
<body>
        <jsp:include page="_include/navbar.jsp" />
        <!-- /navbar -->
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <jsp:include page="_include/sidemenu.jsp" />
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
                            
                            <div class="module">
							<div class="module-head">
								<h3>Fiche Client : ${client.id }</h3>
							</div>
							<div class="module-body">

									<form class="form-horizontal row-fluid" method="post" action="UpdateClient">
										<input type="hidden" id="id" name="id" value="${client.id }">
									
										<div class="control-group">
											<label class="control-label" for="nom">Nom</label>
											<div class="controls">
												<input type="text" id="nom" name="nom" placeholder="indiquer le nom du client..." class="span8" value="${client.nom }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="prenom">Prenom</label>
											<div class="controls">
												<input type="text" id="prenom" name="prenom" placeholder="indiquer le prenom du client..." class="span8" value="${client.prenom }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="numero">Numéro</label>
											<div class="controls">
												<input type="text" id="numero" name="numero" placeholder="ex: +261 32 xx xxx xx" class="span8" value="${client.numero }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="email">Email*</label>
											<div class="controls">
												<input type="text" id="email" name="email" placeholder="ex: xxxx.xxxx@gmail.com" class="span8" value="${client.email }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="mdp">Mot de passe*</label>
											<div class="controls">
												<input type="text" id="mdp" name="mdp" placeholder="indiquer le mot dde passe du client..." class="span8" value="${client.mdp }">
											</div>
										</div>
										
										<div class="control-group">
											<div class="controls">
												<button type="submit" class="btn btn-primary">Mettre à jour</button>
											</div>
										</div>
									</form>
							</div>
						</div>
						
						<div class="module">
                                <div class="module-head">
                                    <h3>
                                        Liste des Commandes du Client</h3>
                                </div>
                                <div class="module-body table">
                                    <table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display"
                                        width="100%">
                                        <thead>
                                            <tr>
                                                <th>
                                                    ID
                                                </th>
                                                <th>
                                                    Date
                                                </th>
                                                <th>
                                                   Etat
                                                </th>
                                                <th>
                                                   Action
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
										<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
										<c:forEach items="${requestScope['commandes']}" var="commande" varStatus="status">
											<tr>
                                                <td>
                                                    ${commande.id }
                                                </td>
                                                <td>
                                                    ${commande.date }
                                                </td>
                                                <td>
                                                    ${commande.client.nom } ${commande.client.prenom }
                                                </td>
                                                <td>
                                                    ${commande.etat }
                                                </td>
                                                <td>
                                                    <a class="btn btn-success" href="FichePlat?id=${commande.id }">Editer</a>
                                                    <a class="btn btn-warning" href="DeletePlat?id=${commande.id }">Supprimer</a>
                                                </td>
                                            </tr>
										</c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--/.module-->
                            
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
                </div>
            </div>
            <!--/.container-->
        </div>
        <!--/.wrapper-->
        <div class="footer">
            <div class="container">
                <b class="copyright">&copy; 2015 - Roots Delivery </b>All rights reserved.
            </div>
        </div>
        <script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="scripts/flot/jquery.flot.js" type="text/javascript"></script>
        <script src="scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
        <script src="scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="scripts/common.js" type="text/javascript"></script>
      
    </body>
</html>