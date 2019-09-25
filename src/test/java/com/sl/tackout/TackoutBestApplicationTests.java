package com.sl.tackout;

import com.sl.tackout.mapper.*;
import com.sl.tackout.pojo.*;
import com.sl.tackout.service.CouponService;
import com.sl.tackout.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TackoutBestApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private BusinessMapper businessMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private CouponService couponService;
	@Autowired
	private CouponMapper couponMapper;

	@Test
	public void contextLoads() {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		Calendar instance = Calendar.getInstance();
//		System.out.println(simpleDateFormat.format(instance.getTime())+"--------------");
//		instance.add(Calendar.DAY_OF_YEAR,3);
////		instance.set(Calendar.DAY_OF_YEAR,instance.get(Calendar.DAY_OF_YEAR)+7);
//		Date time = instance.getTime();
//		System.out.println(time);
//		Date date = new Date();
//		String format = simpleDateFormat.format(time);
//		System.out.println(format);
//		System.out.println(simpleDateFormat.format(date));
		List<CouponTable> aaa = couponMapper.findAllUrCoupon("aaa");
		for (CouponTable c :aaa) {
			System.out.println(c);
		}

	}



}
