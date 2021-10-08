package cn.phpst.mall.api;

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/wx_info")
    @ScopeLevel
    public SuccessDTO updateUserInfo(@RequestBody Map<String,Object> user) {
        userService.updateUserWxInfo(user);
        return new SuccessDTO();
    }
}
