package com.atguigu.dubbo.service.impl;

import com.atguigu.dubbo.bean.Movie;
import com.atguigu.dubbo.bean.Order;
import com.atguigu.dubbo.bean.User;
import com.atguigu.dubbo.bean.service.MovieService;
import com.atguigu.dubbo.bean.service.UserService;

public class UserServiceImpl implements UserService{
	
	MovieService movieService;
	
	

	public MovieService getMovieService() {
		return movieService;
	}



	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}



	@Override
	public Order buyNewMovie(User user) {
		// TODO Auto-generated method stub
		Order order = new Order();
		Movie movie = movieService.getNewMovie();
		System.out.println("远程调用movie服务获取的结果："+movie);
		order.setId(movie.getId());
		order.setMovieName(movie.getMovieName());
		order.setUserName(user.getUserName());
		return order;
	}

}
