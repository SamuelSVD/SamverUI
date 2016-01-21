@echo off
del "C:\Programming\processingjava\Images\frame-00001.tif"
REM del "C:\Programming\processingjava\Images\video.mp4"
REM ffmpeg -i frame-%%05d.tif -r 25 -threads 4 video.mp4

set name=%date:~12,2%%date:~4,2%%date:~7,2%%TIME:~0,2%%TIME:~3,2%%TIME:~6,2%
echo %name%
ffmpeg -i frame-%%05d.tif -r 25 -threads 4 GIFs/%name%.gif
