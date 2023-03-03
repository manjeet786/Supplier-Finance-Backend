package com.supplierfinance.service;


import com.supplierfinance.vo.ClientLoginVO;

public interface ClientLoginService {

Boolean validateLogin(ClientLoginVO clientLoginVO);
}
