package repositories

case class Trade(refNo: String)

trait TradeService {
  def fetchTrade(refNo: String): Trade
  def writeTrade(t: Trade): Unit
}

trait TradeServiceComponent{ this: TradeRepositoryComponent => // self type annotation that indicates the dependency
  val tradeService: TradeService

  class TradeServiceImpl extends TradeService {
    def fetchTrade(refNo: String) = tradeRepo.fetch(refNo)
    def writeTrade(trade: Trade) = tradeRepo.write(trade)
  }
}

//================================================================================
trait TradeRepository {
  def fetch(refNo: String): Trade
  def write(t: Trade): Unit
}

trait TradeRepositoryComponent {
  val tradeRepo: TradeRepository

  class TradeRepositoryImpl extends TradeRepository {
    def fetch(refNo: String): Trade = {
      Trade(refNo)
    }

    def write(t: Trade): Unit = {
      println("got a trade" + t.refNo)
    }
  }
}
//================================================================================

object TradeServiceAssembly extends TradeRepositoryComponent with TradeServiceComponent {
  val tradeRepo = new TradeRepositoryImpl // impl
  val tradeService = new TradeServiceImpl // impl
}
