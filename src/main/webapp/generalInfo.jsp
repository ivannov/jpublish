<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/sb-admin-2.css" rel="stylesheet"/>
`    <link href="css/font-awesome.min.css" rel="stylesheet"/>
</head>
<body>
<jsp:useBean id="website" scope="request" type="com.vidasoft.jpublish.model.Website"/>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">Switch sites</a>
    </div>

    <ul class="nav navbar-top-links navbar-right">
        <li>
            <a href="Generate">
                <i class="fa fa-download"></i>
            </a>
        </li>
    </ul>
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li>
                    <a href="GeneralInfo">General</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">General information</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-6">
                            <form role="form" method="post" action="GeneralInfo">
                                <div class="form-group">
                                    <label for="name">Name</label>
                                    <input id="name" name="name" class="form-control" value="${website.name}" autofocus  onfocus="this.select();">
                                </div>
                                <div class="form-group">
                                    <label for="themes">Theme</label>
                                    <select id="themes" name="themes" class="form-control">
                                        <c:forEach var="theme" items="${availableThemes}">
                                            <option value="${theme.name}" ${theme.name eq website.theme.name ? 'selected = "selected"' : ''}>
                                                    ${theme.displayName}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-default">Save</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>