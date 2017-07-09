<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Websites</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/sb-admin-2.css" rel="stylesheet"/>
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div style="margin-top: 10%">
        <c:forEach items="${websites}" var="website">
            <div class="row">
                <div class="col-lg-offset-4 col-lg-3 col-md-offset-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-edit fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div>${website.name}</div>
                                </div>
                            </div>
                        </div>
                        <a href="GeneralInfo?id=${website.id}">
                            <div class="panel-footer">
                                <span class="pull-left">Edit</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="row">
            <div class="col-lg-offset-4 col-lg-3 col-md-offset-3 col-md-6">
                <div class="panel panel-green">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-plus-circle fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">New!</div>
                                <div>website</div>
                            </div>
                        </div>
                    </div>
                    <a href="GeneralInfo">
                        <div class="panel-footer">
                            <span class="pull-left">Create</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>