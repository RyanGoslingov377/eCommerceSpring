# справление BOM в Java файлах
$files = Get-ChildItem -Recurse -Filter *.java
foreach ($file in $files) {
    $path = $file.FullName
    
    # итаем файл как байты
    $bytes = [System.IO.File]::ReadAllBytes($path)
    
    # роверяем наличие BOM (EF BB BF)
    if ($bytes[0] -eq 0xEF -and $bytes[1] -eq 0xBB -and $bytes[2] -eq 0xBF) {
        Write-Host "айден BOM в: $($file.Name)" -ForegroundColor Red
        
        # итаем файл с правильной кодировкой (игнорируя BOM)
        $reader = New-Object System.IO.StreamReader($path, [System.Text.Encoding]::UTF8, $true)
        $content = $reader.ReadToEnd()
        $reader.Close()
        
        # аписываем обратно без BOM
        [System.IO.File]::WriteAllText($path, $content, [System.Text.UTF8Encoding]::new($false))
        Write-Host "  справлен" -ForegroundColor Green
    }
}
