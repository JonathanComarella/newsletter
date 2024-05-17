package com.jonathancomarella.newsletter.service.impl;

import com.jonathancomarella.newsletter.dto.ClientDto;
import com.jonathancomarella.newsletter.model.Client;
import com.jonathancomarella.newsletter.repository.ClientRepository;
import com.jonathancomarella.newsletter.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        client = clientRepository.save(client);
        return modelMapper.map(client, ClientDto.class);
    }
}
