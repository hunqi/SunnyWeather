# SunnyWeather

---------------------------------------------------------------------------------------------
1. 国家气象局
实时接口：
实时天气1：http://www.weather.com.cn/data/sk/101190408.html
实时天气2：http://www.weather.com.cn/data/cityinfo/101190408.html
实时天气3（带时间戳）：http://mobile.weather.com.cn/data/sk/101010100.html?_=1381891661455

2. 一周天气预报接口
7天预报数据 URL： http://mobile.weather.com.cn/data/forecast/101010100.html?_=1381891660081

3. 获取全国所有城市代码列表
方法一：XML接口根节点： http://flash.weather.com.cn/wmaps/xml/china.xml
    XML接口主要作用是递归获取全国几千个县以上单位的城市代码，如：江苏的XML地址为：
        http://flash.weather.com.cn/wmaps/xml/shanghai.xml 
    苏州的XML地址为：http://flash.weather.com.cn/wmaps/xml/jiangsu.xml上面页面获得太仓city 
    code：101190408合成太仓天气信息地址：http://m.weather.com.cn/data/101190408.html
    下面贴一段PHP代码实现的，通过XML接口根节点递归获得全国几千个县以上城市cide code的代码，供参考(可直接在终端下运行）：
方法二：一次性获取全国+国外主要城市，8763个城市列表信息。URL：http://mobile.weather.com.cn/js/citylist.xml