<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

   <div class="row py-2 ">
                <div class="col-sm-12">
                    <h4 class="text-center" style="border-bottom: 2px solid rgb(255, 115, 0); color: rgb(255, 115, 0);">BEST SELLER</h4>
                    <div class="row bg-white px-0">
                    <c:forEach var="item" items="${lstProduct }">
                    
                        <div class="col-sm-4 py-2">
                            <div class="card card-hover border-0 rounded">
                                <div class="position-relative p-2">
                                  <div class="card-item__img"
                                        style="background-image: url('/ASMJ4/img/${item.img1}');">
                                    </div> 
                                   
                                    <div class="overlay">
                                        <div class="card-item__img2"
                                            style="background-image: url('/ASMJ4/img/${item.img2}');">
                                        </div>
                                    </div>
                                </div>
                                <div class="viewadd position-absolute ">
                                    <a href="/ASMJ4/product/edit?id=${item.id }" type="button" class="btn" >Xem thêm</a>

                                </div>

                            </div>
                            <div class="text-center card-contend py-2">
                                <a href="#" type="button" class="name_product my-0">${item.name}</a>
                                <div class="mx-auto">
                                    <span class="price_old mr-sm-4">350000</span>
                                    <span class="price_new">${item.price}</span>
                                </div>
                                  <c:if test="${item.promotion.percent==0 }">
                                
                                </c:if>
                                 <c:if test="${item.promotion.percent !=0 }">
                                <div class="mx-auto">
                                    <span class="mr-sm-4">Khuyến mãi ${item.promotion.percent } %</span>
                                </div>
                                
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>

                    </div>

                </div>
            </div>
            <div class="row py-2 ">
                <div class="col-sm-12">
                    <h4 class="text-center" style="border-bottom: 2px solid rgb(255, 115, 0); color: rgb(255, 115, 0);">NEW ARRIVAL</h4>
                    <div class="row bg-white px-0">
                    <c:forEach var="item" items="${listNewDate }">
                        <div class="col-sm-4 py-2">
                        
                            <div class="card card-hover border-0 rounded">
                                <div class="position-relative p-2">
                                    <div class="card-item__img"
                                        style="background-image: url(/ASMJ4/img/${item.img1});">
                                    </div>

                                    <div class="overlay">
                                        <div class="card-item__img2"
                                            style="background-image: url(/ASMJ4/img/${item.img2});">
                                        </div>
                                    </div>
                                </div>
                                <div class="viewadd position-absolute ">
                                    <a href="/ASMJ4/product/edit?id=${item.id }" type="button" class="btn">Xem thêm</a>

                                </div>

                            </div>
                            <div class="text-center card-contend py-2">
                                <a href="#" type="button" class="name_product my-0">${item.name}</a>
                                <div class="mx-auto">
                                    <span class="price_old mr-sm-4">350000</span>
                                    <span class="price_new">${item.price}</span>
                                </div>
                                <c:if test="${item.promotion.percent==0 }">
                                
                                </c:if>
                                 <c:if test="${item.promotion.percent !=0 }">
                                <div class="mx-auto">
                                    <span class="mr-sm-4">Khuyến mãi ${item.promotion.percent } %</span>
                                </div>
                                
                                </c:if>
                                
                            </div>
                        </div>
                        
                        </c:forEach>

                    </div>

                </div>
            </div>
           