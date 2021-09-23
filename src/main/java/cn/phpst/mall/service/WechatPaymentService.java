
package cn.phpst.mall.service;

@Service
public class WechatPaymentService {
    @Autowired
    private OrderRepository orderRepository;

    public Map<String,String> preOrder(Long id){
        Long uid =LocalUser.getUser().getId();
        Optional<Order> orderOptional = orderRepository.findFirstByUserIdAndId(id);
    }
}