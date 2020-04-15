package cn.phpst.mall.api;

import cn.phpst.mall.bo.PageCounter;
import cn.phpst.mall.exception.http.NotFoundException;
import cn.phpst.mall.model.BaseEntity;
import cn.phpst.mall.model.Spu;
import cn.phpst.mall.service.SpuService;
import cn.phpst.mall.util.CommonUtil;
import cn.phpst.mall.vo.PagingDozer;
import cn.phpst.mall.vo.SpuSimplifyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/spu")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SpuController extends BaseEntity {
    protected final SpuService spuService;


    @GetMapping("/id/{id}/detail")
    public Spu getById(@PathVariable @Positive Integer id) {
        Spu spu = this.spuService.getById(id);
        if (spu == null) {
            throw new NotFoundException(10001);
        }

        return spu;
    }

    @GetMapping("/last")
    public PagingDozer<Spu,SpuSimplifyVO> getLatestSpuList(
            @RequestParam(defaultValue = "0") Integer start,
            @RequestParam(defaultValue = "10") Integer count) {
        PageCounter pageCounter = CommonUtil.convertToPageParameter(start,count);
        Page<Spu> page = this.spuService.getLatestPaging(pageCounter.getPage(),pageCounter.getCount());
        return new PagingDozer<>(page,SpuSimplifyVO.class);

    }
}
