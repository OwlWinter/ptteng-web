<div class="container">
    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <#assign keys=occupation?keys/>
        <#list keys as key>
            <a class="nav-bar-a" href="#${key}">${key}</a>
        </#list>
    </div>

    <#if occupation??>
        <#list keys as key>
            <div class="caption" id="key">
                <h4>${key}</h4>
            </div>

            <div class="row">
                <#list occupation[key] as job>
                    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                        <div class="warp-border">
                            <div class="clearfix">
                                <div class="icon-people">
                                    <img src="${ctx!"/static"}/imges/${job.imges}">
                                </div>
                                <div class="text">
                                    <h4>${job.major}</h4>
                                    <p class="text-present">${job.introduce}</p>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">
                                        门槛
                                        <#assign x = job.threshold/>
                                        <#list 1..x as i>
                                            <img src="${ctx!"/static"}/imges/xx.png">
                                        </#list>
                                    </div>
                                </div>

                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">
                                        难易程度
                                        <#assign x = job.difficulty/>
                                        <#list 1..x as i>
                                            <img src="${ctx!"/static"}/imges/xx.png">
                                        </#list>
                                    </div>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">
                                        成长周期
                                        <span class="iconfont-color">${job.growthCycle}</span>
                                    </div>
                                </div>

                                <div class="warp-class2-text">
                                    稀缺程度 <span class="iconfont-color">${job.scarcity}</span> 家公司需要
                                </div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="leftWarp">
                                薪资待遇
                            </div>
                            <div class="rightWarp">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">0-1年</div>
                                    <#assign count = job.salary/>
                                    <div class="rightWarp-wages">${count?string["0.#"]}/月</div>
                                </div>
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">1-2年</div>
                                    <#assign count = count*job.coefficient/>
                                    <div class="rightWarp-wages">${count?string["0.#"]}/月</div>
                                </div>
                                <div class="rightWarp-class border-bottom">
                                    <div class="rightWarp-year">2-3年</div>
                                    <#assign count = count*job.coefficient/>
                                    <div class="rightWarp-wages">${count?string["0.#"]}/月</div>
                                </div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <b class="text-b">有${job.numberOfStudent}人正在学</b>
                        </div>
                        <div class="warp-class2">
                            <p class="text-p">${job.prompt}</p>
                        </div>

                        <div class="flip-container">
                            <p class="flip-title">${job.major}</p>
                            <p class="flip-text">${job.introduce}</p>
                        </div>
                    </div>
                </#list>
            </div>
        </#list>
    </#if>

</div>