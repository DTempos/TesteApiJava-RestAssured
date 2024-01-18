#language: pt

@TestarApiRenner
Funcionalidade: Testar API reqres.in para teste Renner

  @PostCreateUser
  Cenario: [POST] Criar usuario
    Quando criar usuario com nome "Testando ewygi44" e trabalho "Job teste kfuwip"
    Entao deve retornar o status code de 201
    E valido o retorno dos dados de acordo com o contrato "apiContract/PostApiUsersCreateResponse.json"

  @GetUser
  Cenario: [GET] Consultar usuario por ID
    Quando consultar um usuario do sistema com ID "2"
    Entao deve retornar o status code de 200
    E valido o retorno dos dados de acordo com o contrato "apiContract/GetApiUsersIdResponse.json"

  @ErrorGetUser
  Cenario: [GET] Validar erro 404 ao tentar consultar usuario que nao existe no sistema
    Quando consultar um usuario do sistema com ID "99"
    Entao deve retornar o status code de 404

  @GetListUsers
  Cenario: [GET] Consultar lista de usuarios
    Quando consultar lista de usuarios do sistema
    Entao deve retornar o status code de 200
    E valido o retorno dos dados de acordo com o contrato "apiContract/GetApiUsersListResponse.json"

  @PatchUpdateUser
  Cenario: [PATCH] Atualizar informacao de usuario
    Quando atualizar informacao de nome "Alterando nome" e trabalho "Alterando trabalho" para o usuario com ID "2"
    Entao deve retornar o status code de 200
    E valido o retorno dos dados de acordo com o contrato "apiContract/PatchUpdateUserResponse.json"