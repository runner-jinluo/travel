package com.example.demo.controller;

import com.example.demo.model.Route;
import com.example.demo.model.User;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {
  
  @Autowired
  private RouteService routeService;
  
  @GetMapping("/all")
  public List<Route> getAllRoutes() {
    return routeService.getAllRoutes();
  }

  @PostMapping("/saveroute")
  public ResponseEntity<?> saveRoute(@RequestBody TempRoute tempRoute) {
    try {
      // 从 TempRoute 对象中获取 List<String>
      List<String> routeList = tempRoute.getRoute();
      // 将 List<String> 转换为单一字符串
      String routeString = String.join("->", routeList);
      // 假设你有一个 Route 类来保存路线信息
      Route route = new Route();
      route.setRoute(routeString);
      routeService.saveRoute(route);
      // 这里你可以添加保存 route 的逻辑
      return ResponseEntity.ok(routeString);
    } catch (Exception e) {
      return ResponseEntity.status(500).body("路线保存失败");
    }
  }

  public static class TempRoute {
    private List<String> route;

    public TempRoute() {
    }

    public TempRoute(List<String> route) {
      this.route = route;
    }

    public List<String> getRoute() {
      return route;
    }

    public void setRoute(List<String> route) {
      this.route = route;
    }
  }

}