package ta.service;

import ta.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
      * @Author: MikeLv
      * @Description: 转账详细信息
      * @Date: 2019/7/17 18:23
      */
    @Override
    public void transfer(String outer, String inner, Double money) {

        transactionTemplate.execute(TransactionStatus ->{
            accountDao.out(outer,money);
            int number = 1/0;
            accountDao.in(inner,money);
            return null;
        });

    }
}
