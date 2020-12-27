package ru.mirea.intro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.intro.dao.RequestDAO;
import ru.mirea.intro.dao.repository.BookRepository;
import ru.mirea.intro.dao.repository.RequestRepository;
import ru.mirea.intro.exception.NoSuchRequest;
import ru.mirea.intro.mapper.RequestMapper;
import ru.mirea.intro.service.TestService;
import ru.mirea.intro.service.model.Request;

import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    RequestRepository requestRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public Request testServiceGetMethod(Long id) throws NoSuchRequest {
        Optional<RequestDAO> requestDAO = requestRepository.findById(id);
        if (requestDAO.isPresent()) {
            return RequestMapper.REQUEST_MAPPER.requestDAOToRequest(requestDAO.get());
        }
        throw new NoSuchRequest();
    }

    @Override
    public Request testServicePostMethod(Request request) {
        RequestDAO requestDAO = RequestMapper.REQUEST_MAPPER.requestToRequestDAO(request);
        requestDAO.getBookDaoList().forEach(bookDao -> bookDao.setRequestDao(requestDAO));
        RequestDAO requestDAOOut = requestRepository.save(requestDAO);
        requestDAOOut.setBookDaoList(bookRepository.findByRequestDaoOrderByIdDesc(requestDAOOut));
        return RequestMapper.REQUEST_MAPPER.requestDAOToRequest(requestDAOOut);
    }

    @Override
    public String testServiceDeleteMethod(Long id) throws NoSuchRequest {
        if (requestRepository.existsById(id)) {
            requestRepository.deleteById(id);
            return "Removal is successful!";
        }
        throw new NoSuchRequest();
    }

    @Override
    public Request testServicePutMethod(Request request) throws NoSuchRequest {
        RequestDAO requestDAOToPut = RequestMapper.REQUEST_MAPPER.requestToRequestDAO(request);
        Long id = requestDAOToPut.getId();
        if (requestRepository.existsById(id)) {
            requestDAOToPut.getBookDaoList().forEach(bookDao -> bookDao.setRequestDao(requestDAOToPut));
            RequestDAO requestDAOOut = requestRepository.save(requestDAOToPut);
            requestDAOOut.setBookDaoList(bookRepository.findByRequestDaoOrderByIdDesc(requestDAOOut));
            return RequestMapper.REQUEST_MAPPER.requestDAOToRequest(requestDAOOut);
        } else throw new NoSuchRequest();
    }
}