package zerobase.weather.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Operation(
            summary = "일기 텍스트와 날짜를 이용해서 DB에 일기 저장합니다.",
            description = "이 API 엔드포인트는 주어진 날짜와 일기 텍스트를 사용하여 데이터베이스에 일기를 저장합니다.",
            parameters = {
                    @Parameter(
                            name = "date",
                            description = "저장할 일기의 날짜를 입력합니다. 형식: yyyy-MM-dd (예: 2024-08-28)",
                            example = "2024-08-28",
                            required = true,
                            schema = @Schema(type = "string", format = "date"))
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "일기 텍스트를 포함하는 요청 본문",
                    content = @Content(
                            schema = @Schema(
                                    type = "string",
                                    example = "오늘은 날씨가 좋다. 일기를 작성합니다."
                            )
                    )
            )
    )
    @PostMapping("/create/diary")
    public void createDiary(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text) {
        diaryService.createDiary(date, text);
    }

    @Operation(
            summary = "선택한 날짜의 모든 일기 데이터를 가져옵니다.",
            description = "이 API 엔드포인트는 지정된 날짜의 모든 일기 데이터를 반환합니다.",
            parameters = {
                    @Parameter(
                            name = "date",
                            description = "조회할 일기의 날짜를 입력합니다. 형식: yyyy-MM-dd (예: 2024-08-28)",
                            example = "2024-08-28",
                            required = true,
                            schema = @Schema(type = "string", format = "date"))
            }
    )
    @GetMapping("/read/diary")
    public List<Diary> readDiary(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return diaryService.readDiary(date);
    }

    @Operation(
            summary = "선택한 기간 중의 모든 일기 데이터를 가져옵니다.",
            description = "이 API 엔드포인트는 지정된 기간(startDate부터 endDate까지) 동안의 모든 일기 데이터를 반환합니다.",
            parameters = {
                    @Parameter(
                            name = "startDate",
                            description = "조회 시작 날짜를 입력합니다. 형식: yyyy-MM-dd (예: 2024-08-01)",
                            example = "2024-08-01",
                            required = true,
                            schema = @Schema(type = "string", format = "date")),
                    @Parameter(
                            name = "endDate",
                            description = "조회 종료 날짜를 입력합니다. 형식: yyyy-MM-dd (예: 2024-08-31)",
                            example = "2024-08-31",
                            required = true,
                            schema = @Schema(type = "string", format = "date"))
            }
    )
    @GetMapping("/read/diaries")
    public List<Diary> readDiaries(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @Operation(
            summary = "선택한 날짜의 일기 데이터를 수정합니다.",
            description = "이 API 엔드포인트는 지정된 날짜의 일기 데이터를 수정합니다.",
            parameters = {
                    @Parameter(
                            name = "date",
                            description = "수정할 일기의 날짜를 입력합니다. 형식: yyyy-MM-dd (예: 2024-08-28)",
                            example = "2024-08-28",
                            required = true,
                            schema = @Schema(type = "string", format = "date"))
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "수정할 일기 텍스트를 포함하는 요청 본문",
                    content = @Content(
                            schema = @Schema(
                                    type = "string",
                                    example = "수정된 일기 내용입니다."
                            )
                    )
            )
    )
    @PutMapping("/update/diary")
    public void updateDiary(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @Operation(
            summary = "선택한 날짜의 일기 데이터를 삭제합니다.",
            description = "이 API 엔드포인트는 지정된 날짜의 일기 데이터를 삭제합니다.",
            parameters = {
                    @Parameter(
                            name = "date",
                            description = "삭제할 일기의 날짜를 입력합니다. 형식: yyyy-MM-dd (예: 2024-08-28)",
                            example = "2024-08-28",
                            required = true,
                            schema = @Schema(type = "string", format = "date"))
            }
    )
    @DeleteMapping("/delete/diary")
    public void deleteDiary(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        diaryService.deleteDiary(date);
    }
}
