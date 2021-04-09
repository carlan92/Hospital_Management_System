# Projeto Final - Centro Hospitalar UPskill

## SI para um Centro Hospitalar UPskill

Desenvolveu-se um Sistema de Informação (SI) para suporte à operação e à gestão de um prestador de serviços de saúde que
detém hospitais e clínicas em vários pontos do país. O sistema responde aos requisitos que se enunciam neste documento.

[Apresentação resumida (pdf)](./Documentação/Apresentação_Finalv2.pdf)


![Sistema Intro](./Hospital_UPskill.png)


## Descrição do Sistema

### Consultas Médicas

<p>Nas unidades de saúde os utentes podem realizar consultas médicas mediante marcação. Por vezes, os utentes não aparecem
ou desistem das consultas que marcaram. É possível também o reagendamento de consultas para outras datas.</p>

<p>Existe acesso à informação de quais ou quantas consultas estão marcadas, realizadas, desmarcadas ou não realizadas por
não comparência do utente. A comparência do utente e a efetiva realização da consulta ficam registadas no sistema.</p>

<p>A chegada do utente ao serviço de consultas é comunicada ao Sistema no balcão de recepção ou pelo próprio utente. A hora
de chegada é registada e o utente introduzido numa lista de espera para chamada. A hora de início e de fim das consultas
também é registada. O médico regista tanto o início como o fim das consulta. Quando o médico chama o utente, o sistema
faz aparecer o nome do utente no ecrã de chamada para consulta. O sistema fecha automaticamente todas as consultas a
decorrer à mais de 24h.</p>

<p>Considera-se falta de comparência se já tiver sido registada a presença do utente, mas este não responder à chamada do
médico. Para a eventualidade de o utente chegar atrasado, é dada uma tolerância de 10 minutos após a chamada para a
consulta. Se a chegada do utente não for registada até essa altura, considera-se que a consulta não é realizada por
falta de comparência. Se, no entanto, o utente ainda comparecer depois dessa tolerância, a consulta poderá ser
realizada, mas só se o médico aprovar.</p>

<p>Quanto às consultas desmarcadas, é possível distinguir se foi por desistência do utente ou do médico. Se a consulta foi
desmarcada por impossibilidade do médico, fica aguadar um novo agendamento.</p>

<p>O estado de facturação da consulta também é registado. Através deste, é possível saber se uma consulta já foi faturada
e, posteriormente, paga. Uma consulta só pode ser faturada se tiver sido realizada. Porque às vezes o sistema de
faturação (um sistema externo) não se encontra operacional, algumas consultas podem ficar por faturar. O sistema deteta
que se trata de uma situação destas se, depois de emitir um pedido de faturação para uma determinada consulta, não
receber qualquer número de fatura emitido pelo sistema externo nos 60 segundos seguintes.</p>

### Níveis de marcação para médico e para especialidade

<p>A visualização das disponibilidades dos médicos e das especialidades é feita por um calendário de vagas. Uma vaga é um
período de tempo reservado para uma consulta, mas que ainda não se encontra atribuído a qualquer utente.</p>

<p>No primeiro dia de cada mês, o sistema preenche o calendário de vagas para o mês seguinte, fazendo isso para cada
médico. A marcação das consultas é feita escolhendo uma vaga. Quando uma consulta é marcada, a vaga relativa a esse
período de tempo é removida do calendário.</p>

<p>De forma a tornar mais fácil a leitura do calendário de vagas, o sistema tem para cada dia o nível de ocupação de cada
médico e de cada especialidade. Tanto para os médicos como para as especialidades existem os seguintes níveis:
Disponível e Não disponível. Não disponível significa que não há quaisquer vagas nesse mesmo dia. Esses dias são
assinalados a vermelho no calendário das disponibilidades. Disponível, significa que existem vagas para o médico ou para
a especialidade e esses dias são assinalados a verde no calendário.</p> 

<p>O interesse em assinalar que um determinado médico ou especialidade ficou sem vagas, relaciona-se com o facto de, nessas
situações, ser possível a abertura de horários extra. Para esse efeito, o sistema envie uma notificação
para os Recepcionistas. Estes têm a possibilidade de abrir novas vagas, em caso de indisponibilidade. Os médicos também
são notificados quando todas as vagas para um determinado mês se encontrem totalmente preenchidas.</p>

### Lista de espera

Os pedidos na lista de espera ficam pendentes até que o sistema lhes atribua uma vaga. Caso isso aconteça, o sistema
envia uma mensagem ao utente para que confirme se que utilizar a vaga em questão. Se o utente não responder dentro do
prazo determinado ou se responder negativamente, o pedido não é satisfeito e a vaga é atribuída ao próximo pedido. O
prazo de resposta são 24h, excepto se a vaga for para o dia seguinte, neste caso o prazo de resposta é de 1h.

Realizado por:

+ [Carla Alexandra Gonçalves Nogueira](https://github.com/carlan92)

+ [Marco Humberto Americo Manuel](https://github.com/Ocram82)

+ [Pedro Miguel Duarte André](https://github.com/PedroMDAndre)

+ [Rodrigo de Sá Ramos Esteves](https://github.com/Kio76)

Turma B
