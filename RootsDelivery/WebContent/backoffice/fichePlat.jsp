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
<title>Fiche Plat</title>
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
								<h3>Nouveau Plat</h3>
							</div>
							<div class="module-body">

									<form class="form-horizontal row-fluid" method="post" action="UpdatePlat" enctype="multipart/form-data">
									<input type="hidden" id="id" name="id" value="${plat.id }">
									
										<div class="control-group">
											<label class="control-label" for="titre">Nom du plat</label>
											<div class="controls">
												<input type="text" id="titre" name="titre" placeholder="indiquer le nom du plat..." class="span8" value="${plat.titre }">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="description">Description</label>
											<div class="controls">
												<textarea id="description" name="description"  class="span8" rows="5" >${plat.description }</textarea>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="prix">Prix</label>
											<div class="controls">
												<div class="input-append">
													<input id="prix" name="prix" type="text" placeholder="ex: 3000" class="span8" value="${plat.prix }"><span class="add-on">Ar</span>
												</div>
													<span class="help-inline">En Ariary et sans virgule</span>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="description">Image/Photo</label>
											<div class="controls">
												<input type="file" id="image" name="image"><br><span class="help-inline">Charger la photo de votre plat</span>
											</div>
												
										</div>

									<div class="control-group">
											<div class="controls">
												<button type="submit" class="btn btn-primary">Enregistrer</button>
											</div>
										</div>
									</form>
							</div>
						</div>
						
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