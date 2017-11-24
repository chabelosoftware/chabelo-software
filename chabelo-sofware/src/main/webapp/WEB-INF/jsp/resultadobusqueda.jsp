<%-- 
    Document   : resultadobusqueda
    Created on : Oct 16, 2017, 5:15:37 PM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
       <link rel="stylesheet" type="text/css" href="<c:url value="/css/resultadobusqueda.css"/> ">

              
        <title>Resultado de Busqueda</title>
    </head>
    <body>
        
    <div class="container">
	<div class="row">
		<section class="content">
			<h1>Usuarios Encontrados</h1>
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="pull-right">
							<div class="input-group">
						<input type="text" class="form-control" placeholder="Search for...">
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit">Buscar</button>
						</span>
					</div>
						</div>
						<div class="table-container">
							<table class="table table-filter">
                                                            <c:forEach var="u" items="${usuarios}">
								<tbody>
									<tr>
										<td></td>
										<td></td>
                                                                                <td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="http://www.prevenciondelaviolencia.org/sites/all/themes/pcc/images/user.png" class="media-photo">
												</a>
												<div class="media-body">
													<span class="media-meta pull-right">Octubre 20 2017</span>
													<h4 class="title">
														${u.getVarNombre()}
													</h4>
													<p class="summary">${u.getVarE_Mail()}</p>
												</div>
                                                                                                <div>
                                                                                                    
                                                                                                </div>
                                                                                                <form action ="/chabelo-sofware/VerOtroPerfil">
                                                                                                    <input name = "u" onlyread value ="${u.getVarNombre_Usuario()}" style="display: none;"/>
                                                                                                    <button class ="btn btn-primary btn-xl" style="color: white; margin: 10px;"> Ver Perfil</button>
                                                                                                </form>
											</div>
										</td>
									</tr>
									
								</tbody>
                                                            </c:forEach>
							</table>
						</div>
					</div>
				</div>
				<div class="content-footer">
					<p>
						Page © - 2017 <br>
                                                Powered By <form action="/chabelo-sofware/"><button>ChabeloSoftware</button></form>
					</p>
				</div>
			</div>
		</section>
		
	</div>
</div>
    </body>
</html>
