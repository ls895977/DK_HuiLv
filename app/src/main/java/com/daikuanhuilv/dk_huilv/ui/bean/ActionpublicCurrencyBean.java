package com.daikuanhuilv.dk_huilv.ui.bean;

import android.os.Debug;

import java.util.List;

public class ActionpublicCurrencyBean {

    /**
     * data : {"data":[{"currency":"USD","name":"美元","rate":"0.1411","updatetime":"2020-03-26 17:10:11","picture":"us","symbol":"$"},{"currency":"EUR","name":"欧元","rate":"0.12891","updatetime":"2020-03-26 17:05:53","picture":"eu","symbol":"\u20ac"},{"currency":"JPY","name":"日元","rate":"15.486","updatetime":"2020-03-26 17:05:53","picture":"jp","symbol":"¥"},{"currency":"HKD","name":"港币","rate":"1.0933","updatetime":"2020-03-26 17:09:53","picture":"hk","symbol":"HK$"},{"currency":"KRW","name":"韩元","rate":"173.186","updatetime":"2020-03-26 17:05:53","picture":"kp","symbol":"\u20a9"},{"currency":"RUB","name":"卢布","rate":"11.0327","updatetime":"2020-03-26 17:05:53","picture":"ru","symbol":"\u20bd"},{"currency":"GBP","name":"英镑","rate":"0.11804","updatetime":"2020-03-26 17:05:53","picture":"gb","symbol":"£"},{"currency":"SGD","name":"新加坡元","rate":"0.2024","updatetime":"2020-03-26 17:05:53","picture":"sg","symbol":"$"},{"currency":"TWD","name":"新台币","rate":"4.2718","updatetime":"2020-03-26 17:05:53","picture":"tw","symbol":"NT$"},{"currency":"CAD","name":"加拿大元","rate":"0.1997","updatetime":"2020-03-26 17:05:53","picture":"ca","symbol":"$"},{"currency":"AUD","name":"澳大利亚元","rate":"0.232","updatetime":"2020-03-26 17:05:53","picture":"au","symbol":"$"},{"currency":"BRL","name":"巴西雷亚尔","rate":"0.70996","updatetime":"2020-03-26 15:55:56","picture":"br","symbol":"R$"},{"currency":"INR","name":"印度卢比","rate":"10.6349","updatetime":"2020-03-26 17:05:53","picture":"in","symbol":"\u20b9"},{"currency":"CHF","name":"瑞士法郎","rate":"0.1368","updatetime":"2020-03-26 17:05:53","picture":"ch","symbol":"CHF"},{"currency":"THB","name":"泰国铢","rate":"4.6149","updatetime":"2020-03-26 17:05:53","picture":"th","symbol":"฿"},{"currency":"MOP","name":"澳门元","rate":"1.12273","updatetime":"2020-03-26 17:09:04","picture":"mo","symbol":"MOP$"},{"currency":"NZD","name":"新西兰元","rate":"0.236","updatetime":"2020-03-26 17:05:53","picture":"nz","symbol":"$"},{"currency":"ZAR","name":"南非兰特","rate":"2.4608","updatetime":"2020-03-26 17:08:53","picture":"za","symbol":"R"},{"currency":"SEK","name":"瑞典克朗","rate":"1.2741","updatetime":"2016-06-30 23:29:36","picture":"se","symbol":"kr"},{"currency":"IDR","name":"印尼卢比","rate":"2299.9","updatetime":"2020-03-26 17:05:53","picture":"id","symbol":"Rp"},{"currency":"MXN","name":"墨西哥比索","rate":"3.36677","updatetime":"2020-03-26 17:09:46","picture":"mx","symbol":"$"},{"currency":"ARS","name":"阿根廷比索","rate":"8.99312","updatetime":"2020-03-26 17:09:04","picture":"ar","symbol":"$"},{"currency":"MYR","name":"林吉特","rate":"0.61026","updatetime":"2020-03-26 17:05:53","picture":"my","symbol":"RM"},{"currency":"OMR","name":"阿曼里亚尔","rate":"0.05412","updatetime":"2020-03-26 17:09:04","picture":"om","symbol":"﷼"},{"currency":"EGP","name":"埃及镑","rate":"2.20751","updatetime":"2020-03-26 17:09:04","picture":"eg","symbol":"£"},{"currency":"PKR","name":"巴基斯坦卢比","rate":"22.59248","updatetime":"2020-03-26 17:09:04","picture":"pk","symbol":"\u20a8"},{"currency":"PYG","name":"巴拉圭瓜拉尼","rate":"919.84083","updatetime":"2020-03-26 17:09:04","picture":"py","symbol":"Gs"},{"currency":"BHD","name":"巴林第纳尔","rate":"0.05318","updatetime":"2020-03-26 17:09:04","picture":"bh","symbol":"BD"},{"currency":"PAB","name":"巴拿马巴尔博亚","rate":"0.14061","updatetime":"2020-03-26 17:09:04","picture":"pa","symbol":"B/."},{"currency":"BMD","name":"百慕大元","rate":"0.14061","updatetime":"2020-03-26 17:09:04","picture":"bm","symbol":"$"},{"currency":"BGN","name":"保加利亚列弗","rate":"0.254","updatetime":"2020-03-26 23:08:42","picture":"bg","symbol":"лв"},{"currency":"ISK","name":"冰岛克朗","rate":"19.76913","updatetime":"2020-03-26 17:09:04","picture":"is","symbol":"kr"},{"currency":"PLN","name":"波兰兹罗提","rate":"0.59032","updatetime":"2020-03-26 17:05:53","picture":"pl","symbol":"zł"},{"currency":"BOB","name":"玻利维亚诺","rate":"0.95752","updatetime":"2020-03-26 17:09:04","picture":"bo","symbol":"$b"},{"currency":"BWP","name":"博茨瓦纳普拉","rate":"1.6655","updatetime":"2020-03-26 16:30:57","picture":"bw","symbol":"P"},{"currency":"DKK","name":"丹麦克朗","rate":"0.96505","updatetime":"2020-03-26 17:09:47","picture":"dk","symbol":"kr."},{"currency":"PHP","name":"菲律宾比索","rate":"7.2019","updatetime":"2020-03-26 17:05:53","picture":"ph","symbol":"\u20b1"},{"currency":"COP","name":"哥伦比亚比索","rate":"571.13933","updatetime":"2020-03-26 17:09:04","picture":"co","symbol":"$"},{"currency":"CUP","name":"古巴比索","rate":"0.14061","updatetime":"2020-03-26 17:09:04","picture":"cu","symbol":"\u20b1"},{"currency":"KZT","name":"哈萨克斯坦坚戈","rate":"62.78174","updatetime":"2020-03-26 17:09:04","picture":"kz","symbol":"\u20b8"},{"currency":"ANG","name":"荷兰盾","rate":"0.25084","updatetime":"2020-03-26 17:09:04","picture":"an","symbol":"ƒ"},{"currency":"CZK","name":"捷克克朗","rate":"3.5479","updatetime":"2020-03-26 17:09:48","picture":"cz","symbol":"Kč"},{"currency":"QAR","name":"卡塔尔里亚尔","rate":"0.5118","updatetime":"2020-03-26 17:09:04","picture":"qa","symbol":"﷼"},{"currency":"KWD","name":"科威特第纳尔","rate":"0.04422","updatetime":"2020-03-26 17:09:04","picture":"kw","symbol":"ك"},{"currency":"HRK","name":"克罗地亚库纳","rate":"0.983","updatetime":"2020-03-26 17:09:04","picture":"hr","symbol":"kn"},{"currency":"KES","name":"肯尼亚先令","rate":"14.91121","updatetime":"2020-03-26 17:09:04","picture":"ke","symbol":"KSh"},{"currency":"LVL","name":"拉脱维亚拉图","rate":"0.0714","updatetime":"2020-03-26 22:18:23","picture":"lv","symbol":"LVL"},{"currency":"LAK","name":"老挝基普","rate":"1254.6","updatetime":"2020-03-26 10:45:55","picture":"la","symbol":"\u20ad"},{"currency":"LBP","name":"黎巴嫩镑","rate":"212.03301","updatetime":"2020-03-26 17:09:04","picture":"lb","symbol":"ل.ل"},{"currency":"LTL","name":"立陶宛立特","rate":"0.39855","updatetime":"2020-03-26 17:09:04","picture":"lt","symbol":"Lt"},{"currency":"RON","name":"罗马尼亚列伊","rate":"0.62399","updatetime":"2020-03-26 17:09:48","picture":"ro","symbol":"lei"},{"currency":"MUR","name":"毛里求斯卢比","rate":"5.51876","updatetime":"2020-03-26 17:09:04","picture":"mu","symbol":"\u20a8"},{"currency":"MNT","name":"蒙古图格里克","rate":"389.78642","updatetime":"2020-03-26 17:09:04","picture":"mn","symbol":"\u20ae"},{"currency":"BDT","name":"孟加拉塔卡","rate":"11.92334","updatetime":"2020-03-26 17:09:04","picture":"bd","symbol":"Tk"},{"currency":"PEN","name":"秘鲁新索尔","rate":"0.48863","updatetime":"2020-03-26 17:09:04","picture":"pe","symbol":"S/."},{"currency":"MAD","name":"摩洛哥迪拉姆","rate":"1.38084","updatetime":"2020-03-26 17:09:46","picture":"ma","symbol":"DH"},{"currency":"NOK","name":"挪威克朗","rate":"1.51038","updatetime":"2020-03-26 17:09:48","picture":"no","symbol":"kr"},{"currency":"SAR","name":"沙特里亚尔","rate":"0.52795","updatetime":"2020-03-26 17:09:04","picture":"sa","symbol":"﷼"},{"currency":"LKR","name":"斯里兰卡卢比","rate":"26.355","updatetime":"2020-03-26 17:05:53","picture":"lk","symbol":"\u20a8"},{"currency":"SOS","name":"索马里先令","rate":"80.28571","updatetime":"2020-03-26 17:09:04","picture":"so","symbol":"S"},{"currency":"TZS","name":"坦桑尼亚先令","rate":"323.25192","updatetime":"2020-03-26 17:09:04","picture":"tz","symbol":"T.Sh."},{"currency":"TND","name":"突尼斯第纳尔","rate":"0.40573","updatetime":"2020-03-26 17:09:49","picture":"tn","symbol":"TD"},{"currency":"TRY","name":"土耳其里拉","rate":"0.90163","updatetime":"2020-03-26 17:09:50","picture":"tr","symbol":"TL"},{"currency":"GTQ","name":"危地马拉格查尔","rate":"1.11451","updatetime":"2020-03-26 17:09:04","picture":"gt","symbol":"Q"},{"currency":"UYU","name":"乌拉圭比索","rate":"6.29491","updatetime":"2020-03-26 17:09:04","picture":"uy","symbol":"$U"},{"currency":"HUF","name":"匈牙利福林","rate":"45.68693","updatetime":"2020-03-26 17:09:47","picture":"hu","symbol":"Ft"},{"currency":"JMD","name":"牙买加元","rate":"18.81301","updatetime":"2020-03-26 17:09:04","picture":"jm","symbol":"J$"},{"currency":"ILS","name":"以色列谢克尔","rate":"0.50823","updatetime":"2020-03-26 17:09:39","picture":"il","symbol":"\u20aa"},{"currency":"JOD","name":"约旦第纳尔","rate":"0.09948","updatetime":"2020-03-26 17:09:04","picture":"jo","symbol":"J.D."},{"currency":"VND","name":"越南盾","rate":"3267.0","updatetime":"2020-03-26 11:15:56","picture":"vn","symbol":"\u20ab"},{"currency":"CLP","name":"智利比索","rate":"118.7413","updatetime":"2020-03-26 17:09:04","picture":"cl","symbol":"$"},{"currency":"PGK","name":"巴布亚新几内亚基那","rate":"0.47806","updatetime":"2020-03-26 17:09:04","picture":"pg","symbol":"K"},{"currency":"KPW","name":"朝鲜圆","rate":"126.5449","updatetime":"2020-03-26 17:09:04","picture":"kp","symbol":"\u20a9"},{"currency":"LSL","name":"莱索托洛提","rate":"2.42826","updatetime":"2020-03-26 17:09:04","picture":"ls","symbol":"LSL"},{"currency":"LYD","name":"利比亚第纳尔","rate":"0.19976","updatetime":"2020-03-26 17:09:04","picture":"ly","symbol":"LD"},{"currency":"RWF","name":"卢旺达法郎","rate":"129.5398","updatetime":"2020-03-26 17:09:04","picture":"rw","symbol":"RF"},{"currency":"MMK","name":"缅甸元","rate":"194.82","updatetime":"2020-03-26 12:35:57","picture":"mm","symbol":"K"},{"currency":"MRO","name":"毛里塔尼亚乌吉亚","rate":"49.91493","updatetime":"2020-03-26 22:43:44","picture":"mr","symbol":"UM"},{"currency":"MWK","name":"马拉维克瓦查","rate":"102.54215","updatetime":"2020-03-26 17:09:04","picture":"mw","symbol":"MK"},{"currency":"NIO","name":"尼加拉瓜科多巴","rate":"4.74825","updatetime":"2020-03-26 17:09:04","picture":"ni","symbol":"C$"},{"currency":"NPR","name":"尼泊尔卢比","rate":"17.11731","updatetime":"2020-03-26 17:09:04","picture":"np","symbol":"\u20a8"},{"currency":"SBD","name":"所罗门群岛元","rate":"1.16023","updatetime":"2020-03-26 17:09:04","picture":"sb","symbol":"$"},{"currency":"SCR","name":"塞舌尔法郎","rate":"1.91786","updatetime":"2020-03-26 17:09:04","picture":"sc","symbol":"\u20a8"},{"currency":"BND","name":"文莱元","rate":"0.20271","updatetime":"2020-03-26 17:05:53","picture":"bn","symbol":"B$"},{"currency":"SYP","name":"叙利亚镑","rate":"72.13059","updatetime":"2020-03-26 17:09:04","picture":"sy","symbol":"£"},{"currency":"DZD","name":"阿尔及利亚第纳尔","rate":"17.28097","updatetime":"2020-03-26 17:09:47","picture":"dz","symbol":"DA"},{"currency":"AED","name":"阿联酋迪拉姆","rate":"0.51637","updatetime":"2020-03-26 17:09:04","picture":"ae","symbol":"د.إ "},{"currency":"BBD","name":"巴巴多斯元","rate":"0.28121","updatetime":"2020-03-26 17:09:04","picture":"bb","symbol":"BDS.$"},{"currency":"AFN","name":"阿富汗尼","rate":"10.77038","updatetime":"2020-03-26 17:09:04","picture":"af","symbol":" ؋"},{"currency":"ALL","name":"阿尔巴尼亚勒克","rate":"15.94466","updatetime":"2020-03-26 17:09:04","picture":"al","symbol":"Lek"},{"currency":"AMD","name":"亚美尼亚德拉姆","rate":"69.66016","updatetime":"2020-03-26 20:00:14","picture":"am","symbol":"֏"},{"currency":"AOA","name":"安哥拉宽扎","rate":"72.18388","updatetime":"2020-03-26 20:37:19","picture":"ao","symbol":"Kz"},{"currency":"AWG","name":"阿鲁巴盾弗罗林","rate":"0.25204","updatetime":"2020-03-26 17:09:04","picture":"aw","symbol":"ƒ"},{"currency":"AZN","name":"阿塞拜疆新马纳特","rate":"0.23896","updatetime":"2020-03-26 18:50:15","picture":"az","symbol":"\u20bc"},{"currency":"BAM","name":"波斯尼亚马尔卡","rate":"0.24","updatetime":"2020-03-26 15:43:36","picture":"ba","symbol":"KM"},{"currency":"BIF","name":"布隆迪法郎","rate":"264.70381","updatetime":"2020-03-26 17:09:04","picture":"bi","symbol":"BIF"},{"currency":"BSD","name":"巴哈马元","rate":"0.14061","updatetime":"2020-03-26 17:09:04","picture":"bs","symbol":"$"},{"currency":"BTN","name":"不丹努扎姆","rate":"10.71976","updatetime":"2020-03-26 23:45:33","picture":"bt","symbol":"Nu"},{"currency":"BYR","name":"白俄罗斯卢布","rate":"2814.92105","updatetime":"2020-03-26 21:27:21","picture":"by","symbol":"Br"},{"currency":"BZD","name":"伯利兹美元","rate":"0.2809","updatetime":"2020-03-26 17:09:04","picture":"bz","symbol":"BZ$"},{"currency":"CDF","name":"刚果法郎","rate":"238.79726","updatetime":"2020-03-26 17:09:04","picture":"cd","symbol":"FC"},{"currency":"CRC","name":"哥斯达黎加科朗","rate":"80.84813","updatetime":"2020-03-26 17:09:04","picture":"cr","symbol":"\u20a1"},{"currency":"CUC","name":"古巴可兑换比索","rate":"0.1399","updatetime":"2020-03-26 21:00:07","picture":"cu","symbol":"CUC$"},{"currency":"CVE","name":"佛得角埃斯库多","rate":"14.29957","updatetime":"2020-03-26 17:09:04","picture":"cv","symbol":"CVE"},{"currency":"DJF","name":"吉布提法郎","rate":"24.95747","updatetime":"2020-03-26 17:09:04","picture":"dj","symbol":"DJF"},{"currency":"DOP","name":"多明尼加比索","rate":"7.56317","updatetime":"2020-03-26 17:09:04","picture":"do","symbol":"RD$"},{"currency":"NGN","name":"尼日利亚奈拉","rate":"51.32099","updatetime":"2020-03-26 17:09:04","picture":"ng","symbol":"\u20a6"},{"currency":"ERN","name":"厄立特里亚纳克法","rate":"2.10768","updatetime":"2020-03-26 17:09:04","picture":"er","symbol":"Nkf"},{"currency":"ETB","name":"埃塞俄比亚比尔","rate":"4.57671","updatetime":"2020-03-26 17:09:04","picture":"et","symbol":"Br"},{"currency":"FJD","name":"斐济元","rate":"0.32874","updatetime":"2020-03-26 17:09:04","picture":"fj","symbol":"F$"},{"currency":"FKP","name":"福克兰镑","rate":"0.10904","updatetime":"2020-03-26 17:09:04","picture":"fk","symbol":"£"},{"currency":"GEL","name":"格鲁吉亚拉里","rate":"0.4836","updatetime":"2020-03-26 20:55:31","picture":"ge","symbol":"ლ"},{"currency":"GIP","name":"直布罗陀镑","rate":"0.10907","updatetime":"2020-03-26 17:09:04","picture":"gi","symbol":"£"},{"currency":"GMD","name":"冈比亚达拉西","rate":"7.10761","updatetime":"2020-03-26 17:09:04","picture":"gm","symbol":"GMD"},{"currency":"GNF","name":"几内亚法郎","rate":"1319.30091","updatetime":"2020-03-26 17:09:04","picture":"gn","symbol":"GNF"},{"currency":"GYD","name":"圭亚那元","rate":"29.00409","updatetime":"2020-03-26 17:09:04","picture":"gy","symbol":"G.$"},{"currency":"HNL","name":"洪都拉斯伦皮拉","rate":"3.46986","updatetime":"2020-03-26 17:09:04","picture":"hn","symbol":"L"},{"currency":"HTG","name":"海地古德","rate":"12.89493","updatetime":"2020-03-26 17:09:04","picture":"ht","symbol":"G"},{"currency":"IQD","name":"伊拉克第纳尔","rate":"167.17988","updatetime":"2020-03-26 17:09:04","picture":"iq","symbol":"د.ع"},{"currency":"IRR","name":"伊朗里亚尔","rate":"5905.42878","updatetime":"2020-03-26 17:09:04","picture":"ir","symbol":"﷼"},{"currency":"KGS","name":"吉尔吉斯斯坦索姆","rate":"11.20836","updatetime":"2020-03-26 18:05:06","picture":"kg","symbol":"лв"},{"currency":"KHR","name":"柬埔寨瑞尔","rate":"567.36","updatetime":"2020-03-26 10:45:55","picture":"kh","symbol":"៛"},{"currency":"KMF","name":"科摩罗法郎","rate":"63.59584","updatetime":"2020-03-26 17:09:04","picture":"km","symbol":"KMF"},{"currency":"KYD","name":"开曼群岛元","rate":"0.1153","updatetime":"2020-03-26 17:09:04","picture":"ky","symbol":"$"},{"currency":"LRD","name":"利比里亚元","rate":"27.69224","updatetime":"2020-03-26 17:09:04","picture":"lr","symbol":"$"},{"currency":"MDL","name":"摩尔多瓦列伊","rate":"2.5084","updatetime":"2020-03-26 17:09:04","picture":"md","symbol":"MDL"},{"currency":"MGA","name":"马尔加什阿里亚","rate":"520.24015","updatetime":"2020-03-26 17:09:04","picture":"mg","symbol":"Ar"},{"currency":"MKD","name":"马其顿第纳尔","rate":"7.99904","updatetime":"2020-03-26 17:09:04","picture":"mk","symbol":"ден"},{"currency":"MVR","name":"马尔代夫拉菲亚","rate":"2.18923","updatetime":"2020-03-26 17:09:04","picture":"mv","symbol":"MVR"},{"currency":"MZN","name":"新莫桑比克梅蒂卡尔","rate":"9.26168","updatetime":"2020-03-26 17:09:04","picture":"mz","symbol":"MT"},{"currency":"NAD","name":"纳米比亚元","rate":"2.43451","updatetime":"2020-03-26 17:09:42","picture":"na","symbol":"$"},{"currency":"RSD","name":"塞尔维亚第纳尔","rate":"15.0884","updatetime":"2020-03-26 16:30:27","picture":"rs","symbol":"РСД"},{"currency":"SDG","name":"苏丹镑","rate":"7.72627","updatetime":"2020-03-26 17:09:04","picture":"sd","symbol":"SDG"},{"currency":"SHP","name":"圣圣赫勒拿镑","rate":"0.10907","updatetime":"2020-03-26 17:09:04","picture":"sh","symbol":"£"},{"currency":"SLL","name":"塞拉利昂利昂","rate":"1360.24522","updatetime":"2020-03-26 17:09:04","picture":"sl","symbol":"Le"},{"currency":"SRD","name":"苏里南元","rate":"1.0447","updatetime":"2020-03-26 17:09:04","picture":"sr","symbol":"$"},{"currency":"STD","name":"圣多美多布拉","rate":"3012.52795","updatetime":"2020-03-26 23:20:16","picture":"st","symbol":"Db"},{"currency":"SZL","name":"斯威士兰里兰吉尼","rate":"2.43058","updatetime":"2020-03-26 17:09:47","picture":"sz","symbol":"¢"},{"currency":"TJS","name":"塔吉克斯坦索莫尼","rate":"1.43411","updatetime":"2020-03-26 17:09:04","picture":"tj","symbol":"TJS"},{"currency":"TMT","name":"土库曼斯坦马纳特","rate":"0.47806","updatetime":"2020-03-26 17:09:04","picture":"tm","symbol":"T"},{"currency":"TOP","name":"汤加潘加","rate":"0.32802","updatetime":"2020-03-26 17:09:04","picture":"to","symbol":"T$"},{"currency":"TTD","name":"特立尼达多巴哥元","rate":"0.94653","updatetime":"2020-03-26 17:09:04","picture":"tt","symbol":"TT$"},{"currency":"UAH","name":"乌克兰格里夫纳","rate":"3.93273","updatetime":"2020-03-26 17:09:04","picture":"ua","symbol":"\u20b4"},{"currency":"UGX","name":"乌干达先令","rate":"529.89","updatetime":"2020-02-01 07:03:26","picture":"ug","symbol":"UGX"},{"currency":"UZS","name":"乌兹别克斯坦苏姆","rate":"1334.34569","updatetime":"2020-03-26 17:09:04","picture":"uz","symbol":"лв"},{"currency":"VEF","name":"委内瑞拉玻利瓦尔","rate":"34899.53741","updatetime":"2020-03-26 17:09:04","picture":"ve","symbol":"Bs."},{"currency":"VUV","name":"瓦努阿图瓦图","rate":"17.29166","updatetime":"2020-03-26 17:09:04","picture":"vu","symbol":"VT"},{"currency":"WST","name":"西萨摩亚塔拉","rate":"0.40438","updatetime":"2020-03-26 17:09:04","picture":"ws","symbol":"$"},{"currency":"XAF","name":"中非金融合作法郎","rate":"84.72462","updatetime":"2020-03-26 17:09:04","picture":"xa","symbol":"XAF"},{"currency":"XCD","name":"东加勒比元","rate":"0.37963","updatetime":"2020-03-26 17:09:04","picture":"xa","symbol":"$"},{"currency":"XOF","name":"西非法郎","rate":"84.72462","updatetime":"2020-03-26 17:09:04","picture":"xa","symbol":"XOF"},{"currency":"XPF","name":"法属波利尼西亚法郎","rate":"15.4202","updatetime":"2020-03-26 17:09:04","picture":"xa","symbol":"XPF"},{"currency":"YER","name":"也门里亚尔","rate":"35.11621","updatetime":"2020-03-26 17:09:04","picture":"ye","symbol":" ﷼"},{"currency":"ZMW","name":"赞比亚克瓦查","rate":"2.47887","updatetime":"2020-03-26 17:09:04","picture":"zm","symbol":"ZK"},{"currency":"SVC","name":"萨尔瓦多科朗","rate":"1.2303","updatetime":"2020-03-26 17:09:04","picture":"sv","symbol":"$"},{"currency":"IEP","name":"爱尔兰镑","rate":0.2135,"updatetime":"2020-03-26 17:10:11","picture":"ie","symbol":"£"},{"currency":"ATS","name":"奥地利先令","rate":1.8182,"updatetime":"2020-03-26 17:10:11","picture":"at","symbol":"ATS"},{"currency":"BEF","name":"比利时法郎","rate":5.3305,"updatetime":"2020-03-26 17:10:11","picture":"be","symbol":"Bi"},{"currency":"DEM","name":"德国马克","rate":0.2584,"updatetime":"2020-03-26 17:10:11","picture":"de","symbol":"DM"},{"currency":"FRF","name":"法国法郎","rate":0.8668,"updatetime":"2020-03-26 17:10:11","picture":null,"symbol":null},{"currency":"FIM","name":"芬兰马克","rate":0.7857,"updatetime":"2020-03-26 17:10:11","picture":"fi","symbol":"FIM"},{"currency":"GHC","name":"加纳塞地","rate":0.8256,"updatetime":"2020-03-26 17:10:11","picture":"gh","symbol":"GH\u20b5"},{"currency":"ZWD","name":"津巴布韦元","rate":47.8469,"updatetime":"2020-03-26 17:10:11","picture":"zw","symbol":"Z$"},{"currency":"BUK","name":"缅甸缅元","rate":224.2152,"updatetime":"2020-03-26 17:10:11","picture":"bu","symbol":"BUK"},{"currency":"PTE","name":"葡萄牙埃斯库多","rate":26.4901,"updatetime":"2020-03-26 17:10:11","picture":"pt","symbol":"PTE"},{"currency":"VEB","name":"委内瑞拉博利瓦","rate":33333.3333,"updatetime":"2020-03-26 17:10:11","picture":"ve","symbol":"VEB"},{"currency":"ESP","name":"西班牙比塞塔","rate":21.9829,"updatetime":"2020-03-26 17:10:11","picture":"es","symbol":"ESP"},{"currency":"GRD","name":"希腊德拉克马","rate":45.0248,"updatetime":"2020-03-26 17:10:11","picture":"gr","symbol":"Δρχ"},{"currency":"ITL","name":"意大利里拉","rate":255.7545,"updatetime":"2020-03-26 17:10:11","picture":"it","symbol":"\u20ac"}]}
     * status : 1
     */

    private DataBeanX data;
    private int status;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBeanX {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            public Double getMoney() {
                return Money;
            }

            public void setMoney(Double money) {
                Money = money;
            }

            public boolean isStatus() {
                return isStatus;
            }

            public void setStatus(boolean status) {
                isStatus = status;
            }

            /**
             * currency : USD
             * name : 美元
             * rate : 0.1411
             * updatetime : 2020-03-26 17:10:11
             * picture : us
             * symbol : $
             */
            private Double Money;
            private boolean isStatus;
            private String currency;
            private String name;
            private String rate;
            private String updatetime;
            private String picture;
            private String symbol;

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRate() {
                return rate;
            }

            public void setRate(String rate) {
                this.rate = rate;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }
        }
    }
}
