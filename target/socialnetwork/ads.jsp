            <div id="myCarousel" class="carousel slide carousel-fade" data-ride="carousel">
                <div class="carousel-inner">
                    <c:forEach var="ad" items="${adsAll}" varStatus="loop">
                        <div class="carousel-item ${loop.index == 0 ? "active" : ""}" >
                            <div class="mask flex-center">
                                <div class="container">
                                    <div class="row align-items-center">
                                        <div class="col-md-7 col-12 order-md-1 order-2">
                                            <h4>${ad.article}</h4>
                                            <p>${ad.content}</p>
                                            <a href="${ad.url}">BUY NOW</a></div>
                                        <div class="col-md-5 col-12 order-md-2 order-1">
                                            <img src="${ad.imgUrl}" class="mx-auto" alt="slide"></div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span> </a>
                    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
            <script type="application/javascript">
                $(document).ready(function () {
                    $('#myCarousel').carousel({
                        interval: 6000,
                    })
                });
            </script>

