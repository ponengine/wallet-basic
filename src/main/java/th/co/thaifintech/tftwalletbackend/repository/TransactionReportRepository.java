package th.co.thaifintech.tftwalletbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import th.co.thaifintech.tftwalletbackend.entity.TransactionReport;
import th.co.thaifintech.tftwalletbackend.entity.User;

public interface TransactionReportRepository extends JpaRepository<TransactionReport, Long>{


}
