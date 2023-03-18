<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>클라우드 챌린지 리스트</title>
<style>

* {
  box-sizing: border-box;
}

body {
  margin: 0;
  min-width: 992px;
  font-family: "Helvetica";
}

.navbar{
  height: 60px;
  padding-left: 30px;
}

.logo{
  line-height: 60px;
  float: left;
}

.logo img{
  vertical-align: middle;
}

.navbar ul{
  float: right;
}

.navbar li{
  list-style-type: none;
  float: left;
  margin-right: 30px;
}

.navbar a{
  text-decoration: none;
  color: black;
  font-style: bold;
  font-size: 13px;
}

.hero_header{
  height: 450px;
  width: 100%;
}

body h1{
  text-align: center;
  margin-top: 60px;
  margin-bottom: 60px;
  font-size: 24px;
  font-style: bold;
  color: #545454;
}

.products {
  margin-left: auto;
  margin-right: auto;
  padding: 0;
  width: 740px;
  text-align: center;
}

.products img{
  width: 225px;
  height: 225px;
  margin-right: 20px;
  margin-bottom: 20px;
}

.products a{
  text-decoration: none;
  color: black;
  float: left;
  font-size: 16px;
}

.price{
  margin-top: 4px;
  margin-bottom: 80px;
}

.clearfix{
  clear: both;
}

.footer{
  text-align: center;
}

.footer img{
  margin-top: 40px;
  height: 20px;
  margin-bottom: 80px;
  margin-left: 10px;
  margin-right: 10px;
}
</style>
</head>
<body>
   
<%@ include file="../common/menubar2.jsp" %>
   
<div class="navbar">
      <a class="logo" href="#">
        <img src="images/logo.png" height="20px">
      </a>
      <ul>
        <li><a href="#">Contact</a></li>
        <li><a href="#">Shop</a></li>
        <li><a href="#">Cart</a></li>
        <li><a href="#">Login</a></li>
      </ul>
    </div>
    
    <img class="hero_header" src="images/hero_header.jpg">
    <h1>클라우드 챌린지</h1>
    <div class="products">
      <a href="#">
        <img src="images/sunglasses.jpg">
        <p>Sunglasses</p>
        <p class="price">49,000</p>
      </a>
      <a href="#">
        <img src="images/tassel_loafer.jpg">
        <p>Tassel Loafer</p>
        <p class="price">89,000</p>
      </a>
      <a href="#">
        <img src="images/beige_bag.jpg">
        <p>Begie Bag</p>
        <p class="price">69,000</p>
      </a>
      <a href="#">
        <img src="images/sneakers.jpg">
        <p>Sneakers</p>
        <p class="price">79,000</p>
      </a>
      <a href="#">
        <img src="images/slippers.jpg">
        <p>Slippers</p>
        <p class="price">29,000</p>
      </a>
      <a href="#">
        <img src="images/wrist_watch.jpg">
        <p>Wrist Watch</p>
        <p class="price">99,000</p>
      </a>
   
      <div class="clearfix"></div>
    </div>
    
    

</body>
</html>