package com.yy.spider.zhihu;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author yuanyang
 * @Description:
 * @date 2018/6/12 16:15
 */
public class ZhihuSpider extends Spider {

    private Random random = new Random();

    private Integer flag = -1;

    private Long t = 0L;

    /**
     *1858,1878,1838,181,199405899602,19940583297
     */
    private List<String> cookies = Arrays.asList("2|1:0|10:1529032745|4:z_c0|92:Mi4xNTNvQkNnQUFBQUFBMEdHOEMtdWxEU1lBQUFCZ0FsVk5LSDRRWEFEdTFXMjhCUTVtY1dpcTMyb1lxQVRjRUZUbHNB|5aaff13963f35328b74609151909b2282b4ab7cc71b20386490ac6a14280be7e"
            ,"2|1:0|10:1528905035|4:z_c0|92:Mi4xZHUtT0F3QUFBQUFBa0M2dWoyeU9EU1lBQUFCZ0FsVk5TNHNPWEFDNHFPUHdNSzZTemNONWQ3QmpuUzg0NktGeW53|6f3ad0b6f3c5a7dcc2f5814fd5da5156d10059ea5889b66d79f25257aa56334e"
            ,"2|1:0|10:1528905437|4:z_c0|92:Mi4xckswRENnQUFBQUFBd09WR0RvVy1EU1lBQUFCZ0FsVk4zWXdPWEFDYUgwMFBicHhtWGlOLUZSVzZBSThBTFJMMmJn|e4825afdd9d9fc88a5d8c46fa0939037a27adb2948d6d94bceb3a64b1539585f"
            ,"2|1:0|10:1528905860|4:z_c0|92:Mi4xb1RaSENnQUFBQUFBNE9iNWhveS1EU1lBQUFCZ0FsVk5oSTRPWEFEMTRCdm80YldELXgxYVMwd1VScVpnT3kwd3Bn|cb48a7cfd4521797e98599c2210ab95f68452d1ed72a6c0644064b6bef2fbca3"
            ,"2|1:0|10:1528906033|4:z_c0|92:Mi4xc2tCSENnQUFBQUFBc0NVd0w0Mi1EU1lBQUFCZ0FsVk5NWThPWEFEbW50TzBxZ1Z0WnBXWEpVcm5YTVVGVkhUS3Rn|be6e7725dede1c0399e42c0d55002e7fa906ebf628a82fe66acfee32a8161ae8"
            ,"2|1:0|10:1528906273|4:z_c0|92:Mi4xZW9CSENnQUFBQUFBb0taaDI0Mi1EU1lBQUFCZ0FsVk5JWkFPWEFDc3k4UkNfWEQ4OC1FN3BNZUNGcXZfamp2eTRn|5105e0d48004de93fd99f2ed8f59d38084ce902c99bbe637ceff0e58124c500f");

    public ZhihuSpider(PageProcessor pageProcessor) {
        super(pageProcessor);
    }

    public void setSite() {
        //随机休眠时间减少被封风险
        site.setSleepTime(2000 + random.nextInt(3000));
        int num = 100;
        if (++flag % num == 0) {
            System.out.println("抓取100个帐号耗时:"+ (System.currentTimeMillis()-t)/1000 + "ms");
            t = System.currentTimeMillis();
            int position = flag / num;
            if (position == cookies.size() - 1) {
                flag = -1;
            }
            //爬取num个页面后切换账号
            site.addCookie("z_c0", cookies.get(position));
            System.out.println("Account number: " + position);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }
}
